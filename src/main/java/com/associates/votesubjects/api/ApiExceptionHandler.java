package com.associates.votesubjects.api;

import com.associates.votesubjects.api.errors.BusinessException;
import com.associates.votesubjects.api.errors.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.associates.votesubjects.controllers")
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String errorMessage = ex.getMessage() != null ? ex.getMessage() : "Not Found";
        return new ResponseEntity<>(new ApiError(errorMessage), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ApiError> handleBusinessException(BusinessException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        return handleExceptionInternal(ex, new ApiError("Validation Failed", ex.getBindingResult().getFieldErrors()), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        String errorMessage = ex.getMostSpecificCause() != null ? ex.getMostSpecificCause().getMessage() : ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(errorMessage), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        return handleExceptionInternal(ex, new ApiError(errorMessage), headers, status, request);
    }
}