package com.associates.votesubjects.repositories;

import com.associates.votesubjects.core.BaseRepository;
import com.associates.votesubjects.models.Vote;

import java.util.Optional;

public interface VoteRepository extends BaseRepository<Vote> {
    Optional<Vote> findOneBySessionIdAndAssociateId(String sessionId, String associateId);
}
