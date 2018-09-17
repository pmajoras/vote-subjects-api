package com.associates.votesubjects.core;

import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import com.associates.votesubjects.services.VoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BaseServiceTests {

    @InjectMocks
    private BaseService<Vote, VoteRepository> baseService =
            Mockito.mock(BaseService.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    private VoteRepository repository;

    @Test
    public void save_shouldReturnSavedData() {
        Vote voteToSave = new Vote();
        given(repository.save(voteToSave)).willReturn(voteToSave);

        Vote savedVote =  baseService.save(voteToSave);

        assertEquals(voteToSave, savedVote);
        assertNotNull(savedVote.getCreatedAt());
    }

    @Test
    public void save_shouldReturnSavedDataAndNotUpdateCreatedAt() {
        Vote voteToSave = new Vote();
        voteToSave.setId("1234");
        given(repository.save(voteToSave)).willReturn(voteToSave);

        Vote savedVote =  baseService.save(voteToSave);

        assertEquals(voteToSave, savedVote);
        assertNull(savedVote.getCreatedAt());
    }

    @Test
    public void findById_shouldReturnVoteById() {
        Vote voteResult = new Vote();
        voteResult.setId("123");
        given(repository.findById("123")).willReturn(Optional.of(voteResult));

        Optional<Vote> foundVote =  baseService.findById("123");

        assertEquals(voteResult, foundVote.get());
        assertEquals(voteResult.getId(), foundVote.get().getId());
    }

    @Test
    public void findAllPaged_shouldReturnDefaultPagedResultWhenPageRequestIsNull() {
        Page<Vote> pagedResult = Page.empty();
        given(repository.findAll(Mockito.any(Pageable.class))).willReturn(pagedResult);

        Page<Vote> result = baseService.findAllPaged(null);
        assertEquals(pagedResult, result);
    }
}
