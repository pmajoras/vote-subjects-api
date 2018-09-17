package com.associates.votesubjects.services;

import com.associates.votesubjects.api.models.VoteOptionResult;
import com.associates.votesubjects.api.models.VoteResult;
import com.associates.votesubjects.repositories.VoteResultRepository;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteResultService {

    private final VoteSessionRepository voteSessionRepository;
    private final VoteResultRepository voteResultRepository;

    @Autowired
    public VoteResultService(VoteSessionRepository voteSessionRepository, VoteResultRepository voteResultRepository) {
        this.voteSessionRepository = voteSessionRepository;
        this.voteResultRepository = voteResultRepository;
    }

    public Optional<VoteResult> getVoteSessionResult(final String voteSessionId) {
        VoteResult voteResult;

        voteResult = this.voteSessionRepository.findById(voteSessionId)
                .map(voteSession -> {
                    List<VoteOptionResult> optionResults = voteResultRepository.findVoteOptionResultsBySessionId(voteSessionId);
                    return new VoteResult(voteSession, optionResults);
                }).orElse(null);

        return Optional.ofNullable(voteResult);
    }
}