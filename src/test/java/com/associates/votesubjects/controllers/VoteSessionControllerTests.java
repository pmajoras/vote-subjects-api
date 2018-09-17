package com.associates.votesubjects.controllers;

import com.associates.votesubjects.api.models.VoteResult;
import com.associates.votesubjects.services.VoteResultService;
import com.associates.votesubjects.services.VoteSessionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class VoteSessionControllerTests {

    private MockMvc mockMvc;

    @InjectMocks
    private VoteSessionController voteSessionController;

    @Mock
    private VoteSessionService voteSessionService;
    @Mock
    private VoteResultService voteResultService;

    private ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(voteSessionController)
                .build();
    }

    @Test
    public void getSessionVoteResultById_ShouldReturnOkStatusWhenVoteResultIsFound() throws Exception {
        VoteResult voteResult = new VoteResult(null, null);
        given(voteResultService.getVoteSessionResult("123")).willReturn(Optional.of(voteResult));

        this.mockMvc.perform(get("/v1/votesession/123/result")
                .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().bytes(mapper.writeValueAsBytes(voteResult)));
    }

    @Test
    public void getSessionVoteResultById_ShouldReturnNotFoundStatusWhenResultIsNotFound() throws Exception {
        given(voteResultService.getVoteSessionResult("123")).willReturn(Optional.empty());

        this.mockMvc.perform(get("/v1/votesession/123/result")
                .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isNotFound());
    }
}
