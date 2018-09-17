package com.associates.votesubjects.controllers;

import com.associates.votesubjects.core.BaseController;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import com.associates.votesubjects.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vote")
public class VoteController extends BaseController<Vote, VoteService, VoteRepository> {

    @Autowired
    public VoteController(VoteService service){
        super(service);
    }
}