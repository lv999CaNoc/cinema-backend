package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.entity.Role;
import com.example.cinema.pojo.entity.SecureToken;
import com.example.cinema.pojo.entity.User;
import com.example.cinema.pojo.requests.LoginRequest;
import com.example.cinema.pojo.requests.RegisterRequest;
import com.example.cinema.pojo.responses.AuthenticationResponse;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.RoleRepository;
import com.example.cinema.repository.SecureTokenRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.security.JwtTokenProvider;
import com.example.cinema.service.AuthService;
import com.example.cinema.service.LoginAttemptService;
import com.example.cinema.service.SecureTokenService;
import com.example.cinema.util.RequestUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final JavaMailSender mailSender;

    private final SecureTokenService secureTokenService;

    private final SecureTokenRepository secureTokenRepository;

    private final RequestUtils requestUtils;
    private final LoginAttemptService loginAttemptService;

    @Value("${site.base.url}")
    private String BASE_URL;

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new CinemaException(ExceptionCode.USERNAME_ALREADY_EXIST);
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CinemaException(ExceptionCode.EMAIL_ALREADY_EXIST);
        }
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .email(request.getEmail())
                .dayOfBirth(request.getDayOfBirth())
                .isEnabled(false)
                .build();
        userRepository.save(newUser);

        try {
            sendRegisterVerifyEmail(newUser);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new CinemaException(ExceptionCode.SEND_MAIL_ERROR);
        }

        String msg = "Register successfully! Check your email to verify your account.";
        return ResponseEntity.ok(BaseResponse.of(msg));
    }

    @Override
    public void sendRegisterVerifyEmail(User user)
            throws MessagingException, UnsupportedEncodingException {
        SecureToken secureToken = secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);

        String toAddress = user.getEmail();
        String subject = "[Cinema] Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Cinema App.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = BASE_URL + "/api/auth/verify?token=" + secureToken.getToken();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public boolean verifyEmail(String token) {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if (Objects.isNull(secureToken) || secureToken.isExpired()) {
            throw new CinemaException(ExceptionCode.INVALID_VERIFY_EMAIL_TOKEN);
        }
        Optional<User> user = userRepository.findById(secureToken.getUser().getId());
        if (Objects.isNull(user)) {
            return false;
        }

        User verifyUser = user.get();
        verifyUser.setEnabled(true);
        userRepository.save(verifyUser);

        secureTokenService.removeToken(secureToken);
        return true;
    }

    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        String ip = requestUtils.getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new CinemaException(ExceptionCode.BLOCK_IP);
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        loginAttemptService.loginSucceeded(ip);

        Object principal = authentication.getPrincipal();
        User user = (User) principal;

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        LocalDateTime dob = user.getDayOfBirth();
        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .token(jwtTokenProvider.generateToken(authentication))
                .roles(roles)
                .dayOfBirth(dob)
                .build();
        return ResponseEntity.ok(BaseResponse.of(authResponse));
    }

    @Override
    public User getUser() throws RuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        throw new CinemaException(ExceptionCode.UNAUTHORIZED);
    }


}
