package com.associates.votesubjects.api.models;

import com.associates.votesubjects.models.VoteSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VoteResultTests {

    @Test
    public void constructor_shouldHaveSamePropertiesPassedInConstructor() {
        VoteSession session = new VoteSession();
        List<VoteOptionResult> options = new ArrayList<>();
        options.add(new VoteOptionResult());
        VoteResult voteResult = new VoteResult(session, options);

        assertEquals(session, voteResult.getSession());
        assertEquals(options, voteResult.getOptionsResults());
    }
}
