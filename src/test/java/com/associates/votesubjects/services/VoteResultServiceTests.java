package com.associates.votesubjects.services;

import com.associates.votesubjects.api.models.VoteOptionResult;
import com.associates.votesubjects.api.models.VoteResult;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.VoteResultRepository;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class VoteResultServiceTests {

    private VoteResultService voteResultService;

    @Mock
    private VoteSessionRepository voteSessionRepository;

    @Mock
    private VoteResultRepository voteResultRepository;

    @Before
    public void setup() {
        voteResultService = new VoteResultService(voteSessionRepository, voteResultRepository);
    }

    @Test
    public void getVoteSessionResult_shouldReturnVoteResultWhenSessionIsFound() {
        VoteSession voteSession = new VoteSession();
        List<VoteOptionResult> optionResults = Arrays.asList(new VoteOptionResult());

        given(voteSessionRepository.findById("123")).willReturn(Optional.of(voteSession));
        given(voteResultRepository.findVoteOptionResultsBySessionId("123")).willReturn(optionResults);

        VoteResult voteResult = voteResultService.getVoteSessionResult("123").get();

        assertEquals(voteSession, voteResult.getSession());
        assertEquals(optionResults, voteResult.getOptionsResults());
    }

    @Test
    public void getVoteSessionResult_shouldReturnNullWhenSessionIsNotFound() {
        given(voteSessionRepository.findById("123")).willReturn(Optional.empty());

        assertFalse(voteResultService.getVoteSessionResult("123").isPresent());
    }
}