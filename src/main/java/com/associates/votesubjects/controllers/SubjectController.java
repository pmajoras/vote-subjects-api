package com.associates.votesubjects.controllers;

import com.associates.votesubjects.core.BaseController;
import com.associates.votesubjects.api.errors.EntityNotFoundException;
import com.associates.votesubjects.models.Subject;
import com.associates.votesubjects.repositories.SubjectRepository;
import com.associates.votesubjects.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/subject")
public class SubjectController extends BaseController<Subject, SubjectService, SubjectRepository> {

    @Autowired
    public SubjectController(SubjectService service){
        super(service);
    }

    @Override
    @GetMapping("/{slugOrId}")
    public Subject getById(@Valid @PathVariable("slugOrId") final String slugOrId) {
        return service.findBySlugOrId(slugOrId).orElseThrow(EntityNotFoundException::new);
    }
}
