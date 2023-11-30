package com.example.cinema.exception;

import lombok.Getter;

import javax.management.loading.MLetContent;

@Getter
public enum ExceptionCode {
    REFRESH_TOKEN_NOT_FOUND("400", "Token not found"),
    INVALID_JWT_TOKEN("403", "Invalid JWT token"),
    EXPIRED_JWT_TOKEN("403", "Expired JWT token"),
    UNSUPPORTED_JWT_TOKEN("403", "Unsupported JWT token"),
    JWT_EMPTY("403", "JWT claims string is empty"),
    EXPIRED_REFRESH_TOKEN("403", "Expired Refresh Token"),
    USERNAME_ALREADY_EXIST("409", "Username Already Exist"),
    EMAIL_ALREADY_EXIST("409", "Email Already Exist"),
    PHONE_ALREADY_EXIST("409", "Phone Already Exist"),
    MOVIE_NOT_FOUND("400", "Movie Not Found"),
    BILL_NOT_FOUND("400", "Bill Not Found"),
    SEAT_NOT_FOUND("400", "Seat Not Found"),
    SEAT_NOT_AVAIlABLE("400", "Seat Not Available, Someone Else Booked"),
    INVALID_CREDENTIALS("401", "Invalid credentials"),
    INTERNAL_SERVER_ERROR("500", "Internal server error"),
    MB_WEB_INVALID_PARAM("400", "Invalid param"),;
    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
