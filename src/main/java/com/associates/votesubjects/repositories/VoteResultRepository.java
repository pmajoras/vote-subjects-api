package com.associates.votesubjects.repositories;

import com.associates.votesubjects.api.models.VoteOptionResult;
import java.util.List;

public interface VoteResultRepository {
    List<VoteOptionResult> findVoteOptionResultsBySessionId(String sessionId);
}
