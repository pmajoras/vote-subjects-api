package com.associates.votesubjects.core.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Entity not found")
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}