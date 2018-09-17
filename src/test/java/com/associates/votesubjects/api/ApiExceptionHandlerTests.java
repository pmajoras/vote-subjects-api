package com.associates.votesubjects.api;

import com.associates.votesubjects.api.errors.BusinessException;
import com.associates.votesubjects.api.errors.EntityNotFoundException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ApiExceptionHandlerTests {

    private ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();

    @Test
    public void handleAllExceptions_shouldReturnInternalServerError() {
        ResponseEntity<ApiError> error = apiExceptionHandler.handleAllExceptions(null, null);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, error.getStatusCode());
        assertEquals("Internal Server Error", error.getBody().getMessage());
    }

    @Test
    public void handleEntityNotFoundException_shouldReturnNotFoundWithDefaultMessage() {
        ResponseEntity<ApiError> error = apiExceptionHandler.handleEntityNotFoundException(new EntityNotFoundException(), null);
        assertEquals(HttpStatus.NOT_FOUND, error.getStatusCode());
        assertEquals("Not Found", error.getBody().getMessage());
    }

    @Test
    public void handleEntityNotFoundException_shouldReturnNotFoundWithCustomMessage() {
        ResponseEntity<ApiError> error = apiExceptionHandler.handleEntityNotFoundException(new EntityNotFoundException("Test Message"), null);
        assertEquals(HttpStatus.NOT_FOUND, error.getStatusCode());
        assertEquals("Test Message", error.getBody().getMessage());
    }

    @Test
    public void handleBusinessException_shouldReturnBadRequestWithCustomMessage() {
        ResponseEntity<ApiError> error = apiExceptionHandler.handleBusinessException(new BusinessException("Test Message123"), null);
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
        assertEquals("Test Message123", error.getBody().getMessage());
    }
}