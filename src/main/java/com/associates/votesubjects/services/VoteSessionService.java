package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSessionService extends BaseService<VoteSession, VoteSessionRepository> {

    @Autowired
    public VoteSessionService(VoteSessionRepository repository){
        super(repository);
    }
}
