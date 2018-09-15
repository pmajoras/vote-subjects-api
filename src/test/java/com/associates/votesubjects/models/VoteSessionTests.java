package com.associates.votesubjects.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class VoteSessionTests {

    @Test
    public void constructor_shouldCreateVoteSessionWithExpiresAtOneMinuteFromNow() {
        LocalDateTime nowPlusOneMinute = LocalDateTime.now().plusMinutes(1);
        VoteSession voteSession = new VoteSession();

        assertNotNull(voteSession.getExpiresAt());
        assertEquals(nowPlusOneMinute.getMinute(), voteSession.getExpiresAt().getMinute());
    }
}
