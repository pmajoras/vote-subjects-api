package com.associates.votesubjects.core;

import com.associates.votesubjects.api.errors.EntityNotFoundException;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import com.associates.votesubjects.services.VoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void getAll_shouldFindPageResultObjectWithPassedPageAndSizes() {
        Page<Vote> expectedPageResult = Page.empty();
        given(service.findAllPaged(Mockito.any(PageRequest.class))).willReturn(expectedPageResult);

        Page<Vote> result = baseController.getAll(2, 1);
        assertEquals(expectedPageResult, result);
        verify(service).findAllPaged(argThat(argPageResult -> argPageResult.getPageNumber() == 1 && argPageResult.getPageSize() == 1));
    }

    @Test
    public void getAll_shouldFindPageResultObjectWithDefaultPageAndSize() {
        Page<Vote> expectedPageResult = Page.empty();
        given(service.findAllPaged(Mockito.any(PageRequest.class))).willReturn(expectedPageResult);

        Page<Vote> result = baseController.getAll(0, 0);
        assertEquals(expectedPageResult, result);
        verify(service).findAllPaged(argThat(argPageResult -> argPageResult.getPageNumber() == 0 && argPageResult.getPageSize() == 100));
    }
}
