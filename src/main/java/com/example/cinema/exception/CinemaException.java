package com.example.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CinemaException extends RuntimeException{
    private String message;

    public CinemaException(String message){
        super(message);
        this.message = message;
    }
}
