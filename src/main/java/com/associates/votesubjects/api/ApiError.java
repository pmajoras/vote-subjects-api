package com.associates.votesubjects.api;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
public class ApiError {
    private String message;
    private List<FieldError> fieldErrors;

    public ApiError(String message) {
        this.message = message;
    }

    public ApiError(String message, List<FieldError> fieldErrors) {
        this.message = message;
        this.fieldErrors = fieldErrors;
    }
}
