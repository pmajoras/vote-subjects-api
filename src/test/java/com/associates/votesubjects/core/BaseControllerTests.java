package com.associates.votesubjects.core;

import com.associates.votesubjects.core.errors.EntityNotFoundException;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import com.associates.votesubjects.services.VoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BaseControllerTests {

    @InjectMocks
    private BaseController<Vote, VoteService, VoteRepository> baseController =
            Mockito.mock(BaseController.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    private VoteService service;

    @Test
    public void save_shouldReturnSavedData() {
        Vote voteToSave = new Vote();
        Vote voteResult = new Vote();
        given(service.save(voteToSave)).willReturn(voteResult);

        assertEquals(voteResult, baseController.create(voteToSave));
    }

    @Test
    public void getById_shouldReturnVoteById() {
        Vote voteResult = new Vote();
        given(service.findById("123")).willReturn(Optional.of(voteResult));

        assertEquals(voteResult, baseController.getById("123"));
    }

    @Test(expected = EntityNotFoundException.class)
    public void getById_shouldThrowExceptionWhenVoteIsNotFound() {
        given(service.findById("123")).willReturn(Optional.empty());
        baseController.getById("123");
        fail();
    }
}
