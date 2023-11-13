package com.example.cinema.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CinemaException extends RuntimeException{
    private ExceptionCode exceptionCode;
    private Object[] args;

    public CinemaException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
