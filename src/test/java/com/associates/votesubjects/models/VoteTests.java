package com.associates.votesubjects.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class VoteTests {

    @Test
    public void isOptionValid_shouldReturnTrueWhenOptionIsLowerCaseYes() {
        Vote vote = new Vote();
        vote.setOption("yes");

        assertTrue(vote.isOptionValid());
    }

    @Test
    public void isOptionValid_shouldReturnTrueWhenOptionIsLowerCaseNo() {
        Vote vote = new Vote();
        vote.setOption("no");

        assertTrue(vote.isOptionValid());
    }

    @Test
    public void isOptionValid_shouldReturnFalseWhenOptionIsMixedCaseNo() {
        Vote vote = new Vote();
        vote.setOption("No");

        assertFalse(vote.isOptionValid());
    }

    @Test
    public void isOptionValid_shouldReturnFalseWhenOptionIsMixedCaseYes() {
        Vote vote = new Vote();
        vote.setOption("Yes");

        assertFalse(vote.isOptionValid());
    }

    @Test
    public void isOptionValid_shouldReturnFalseWhenOptionIsUpperCaseYes() {
        Vote vote = new Vote();
        vote.setOption("YES");

        assertFalse(vote.isOptionValid());
    }

    @Test
    public void isOptionValid_shouldReturnFalseWhenOptionIsUpperCaseNo() {
        Vote vote = new Vote();
        vote.setOption("NO");

        assertFalse(vote.isOptionValid());
    }
}