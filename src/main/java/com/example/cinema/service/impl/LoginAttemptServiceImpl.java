package com.example.cinema.service.impl;

import com.example.cinema.service.LoginAttemptService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LoginAttemptServiceImpl implements LoginAttemptService {
    private final int MAX_ATTEMPT = 5;

    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptServiceImpl() {
        attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Integer>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    @Override
    public void loginSucceeded(String key) {
        attemptsCache.invalidate(key);
        log.error("Login Successed: " + key + ".");
    }

    @Override
    public void loginFailed(String key) {
        int attempts = 0;
        try {
            attempts = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }
        attempts++;
        attemptsCache.put(key, attempts);
        log.error("Login Failed: " + key + ". Attempt: " + attempts);
    }

    @Override
    public boolean isBlocked(String key) {
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            return false;
        }
    }
}
