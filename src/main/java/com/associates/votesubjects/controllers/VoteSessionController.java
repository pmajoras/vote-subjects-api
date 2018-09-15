package com.associates.votesubjects.controllers;

import com.associates.votesubjects.core.BaseController;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import com.associates.votesubjects.services.VoteSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votesession")
public class VoteSessionController extends BaseController<VoteSession, VoteSessionService, VoteSessionRepository> {

    @Autowired
    public VoteSessionController(VoteSessionService service){
        super(service);
    }
}
