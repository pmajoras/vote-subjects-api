package com.associates.votesubjects.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VoteSessionTests {

    @Test
    public void constructor_shouldCreateVoteSessionWithExpiresAtOneMinuteFromNow() {
        LocalDateTime nowPlusOneMinute = LocalDateTime.now().plusMinutes(1);
        VoteSession voteSession = new VoteSession();

        assertNotNull(voteSession.getExpiresAt());
        assertEquals(nowPlusOneMinute.getMinute(), voteSession.getExpiresAt().getMinute());
    }

    @Test
    public void isExpired_shouldReturnTrueWhenExpiresAtIsLowerThenCurrentDate() {
        VoteSession voteSession = new VoteSession();
        voteSession.setExpiresAt(LocalDateTime.now().plusMinutes(-5));

        assertTrue(voteSession.isExpired());
    }

    @Test
    public void isExpired_shouldReturnFalseWhenExpiresAtIsGreaterThenCurrentDate() {
        VoteSession voteSession = new VoteSession();
        assertFalse(voteSession.isExpired());
    }
}
