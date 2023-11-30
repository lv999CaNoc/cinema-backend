package com.example.cinema.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;
@Data
public class ValidationException extends RuntimeException{
    private BindingResult bindingResult;

    public ValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
