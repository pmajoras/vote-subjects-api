package com.associates.votesubjects.api.errors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessExceptionTests {

    @Test
    public void constructor_shouldHaveSameMessageAsPassedInConstructor() {
        BusinessException businessException = new BusinessException("Test Message");
        assertEquals("Test Message", businessException.getMessage());
    }
}