package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends BaseService<Vote, VoteRepository> {

    @Autowired
    public VoteService(VoteRepository repository){
        super(repository);
    }
}
