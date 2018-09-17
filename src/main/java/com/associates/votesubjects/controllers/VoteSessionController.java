package com.associates.votesubjects.controllers;

import com.associates.votesubjects.api.errors.EntityNotFoundException;
import com.associates.votesubjects.api.models.VoteOptionResult;
import com.associates.votesubjects.api.models.VoteResult;
import com.associates.votesubjects.core.BaseController;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import com.associates.votesubjects.services.VoteResultService;
import com.associates.votesubjects.services.VoteSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/votesession")
public class VoteSessionController extends BaseController<VoteSession, VoteSessionService, VoteSessionRepository> {
    private final VoteResultService voteResultService;

    @Autowired
    public VoteSessionController(VoteSessionService service, VoteResultService voteResultService){
        super(service);
        this.voteResultService = voteResultService;
    }

    @GetMapping("/{id}/result")
    public VoteResult getSessionVoteResultById(@Valid @PathVariable("id") final String id) {
        return voteResultService.getVoteSessionResult(id).orElseThrow(EntityNotFoundException::new);
    }
}
