package com.associates.votesubjects.services;

import com.associates.votesubjects.api.errors.BusinessException;
import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.models.Vote;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.VoteRepository;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends BaseService<Vote, VoteRepository> {
    private final VoteSessionRepository voteSessionRepository;

    @Autowired
    public VoteService(VoteRepository repository, VoteSessionRepository voteSessionRepository) {
        super(repository);
        this.voteSessionRepository = voteSessionRepository;
    }

    @Override
    public Vote save(final Vote entity) {
        if (!entity.isOptionValid()) {
            throw new BusinessException("Option field must be 'yes' or 'no'.");
        }

        this.verifyIfVoteSessionIsOpen(entity);
        this.verifyIfAssociateAlreadyVotedInSession(entity.getSessionId(), entity.getAssociateId());

        return super.save(entity);
    }

    private void verifyIfAssociateAlreadyVotedInSession(String sessionId, String associateId) {
        repository.findOneBySessionIdAndAssociateId(sessionId, associateId)
                .ifPresent(vote -> {
                    throw new BusinessException("This associate has already voted on this session.");
                });
    }

    private void verifyIfVoteSessionIsOpen(final Vote entity) {
        VoteSession voteSession = this.voteSessionRepository.findById(entity.getSessionId())
                .orElseThrow(() -> new BusinessException("The session Id is invalid"));

        if (voteSession.isExpired()) {
            throw new BusinessException("The session has already expired.");
        }
    }
}
