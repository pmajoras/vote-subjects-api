package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.repositories.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends BaseService<Vote, VoteRepository> {
}
