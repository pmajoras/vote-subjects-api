package com.associates.votesubjects.api;

import org.junit.Test;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ApiErrorTests {

    @Test
    public void constructor_shouldHaveMessageAsPassedOnParameterAndFieldsNull() {
        ApiError apiError = new ApiError("Test Message");

        assertEquals("Test Message", apiError.getMessage());
        assertNull(apiError.getFieldErrors());
    }

    @Test
    public void constructor_shouldHaveMessageAndFieldsAsPassedOnParameter() {
        List<FieldError> fieldErrors = new ArrayList<>();
        ApiError apiError = new ApiError("Test Message", fieldErrors);

        assertEquals("Test Message", apiError.getMessage());
        assertEquals(fieldErrors, apiError.getFieldErrors());
    }
}
