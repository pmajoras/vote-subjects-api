package com.associates.votesubjects.services;

import com.associates.votesubjects.models.Subject;
import com.associates.votesubjects.repositories.SubjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTests {

    @InjectMocks
    private SubjectService subjectService;

    @Mock
    private SubjectRepository repository;

    @Test
    public void findBySlugOrId_shouldReturnSubjectBySlug() {
        String slug = "abc-123";
        Subject foundSubject = new Subject();
        given(repository.findOneBySlugOrId(slug, slug)).willReturn(Optional.of(foundSubject));

        assertEquals(foundSubject, subjectService.findBySlugOrId(slug).get());
    }

    @Test
    public void save_shouldSaveSubjectWithSlug() {
        Subject subjectToSave = new Subject();
        subjectToSave.setTitle("Test Title");
        subjectToSave.setDescription("Test Description");
        subjectToSave.setSlug("Will Be Changed");
        given(repository.save(subjectToSave)).willReturn(subjectToSave);

        assertEquals(subjectToSave, subjectService.save(subjectToSave));
        assertEquals("test-title", subjectToSave.getSlug());
    }
}
