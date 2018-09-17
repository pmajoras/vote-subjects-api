package com.associates.votesubjects.controllers;


import com.associates.votesubjects.models.Subject;
import com.associates.votesubjects.services.SubjectService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTests {

    private MockMvc mockMvc;

    @InjectMocks
    private SubjectController subjectController;

    @Mock
    private SubjectService subjectService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(subjectController)
                .build();
    }

    @Test
    public void getById_ShouldReturnOkStatusWhenSubjectIsFound() throws Exception {
        Subject subjectResult = new Subject();
        given(subjectService.findBySlugOrId("123")).willReturn(Optional.of(subjectResult));

        this.mockMvc.perform(get("/v1/subject/123")
                .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getById_ShouldReturnNotFoundStatusWhenSubjectIsNotFound() throws Exception {
        given(subjectService.findBySlugOrId("123")).willReturn(Optional.empty());

        this.mockMvc.perform(get("/v1/subject/123")
                .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isNotFound());
    }
}
