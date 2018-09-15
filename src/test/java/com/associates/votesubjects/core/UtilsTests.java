package com.associates.votesubjects.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTests {

    @Before
    public void setUp() {
    }

    @Test
    public void getSlugFromString_shouldReturnEmptyStringWhenStringIsEmpty() {
        assertEquals("", Utils.getSlugFromString(""));
    }

    @Test
    public void getSlugFromString_shouldReturnEmptyStringWhenStringIsNull() {
        assertEquals("", Utils.getSlugFromString(null));
    }

    @Test
    public void getSlugFromString_shouldReturnLowerCaseSlugStringWhenStringIsHasValue() {
        assertEquals("test-slug", Utils.getSlugFromString("Test Slug"));
        assertEquals("test-slug", Utils.getSlugFromString("test Slug"));
        assertEquals("test-slug-ab123", Utils.getSlugFromString("TEST SLUG AB123"));
        assertEquals("testslug", Utils.getSlugFromString("testSlug"));
    }
}


