package com.associates.votesubjects.api.models;

import com.associates.votesubjects.models.VoteSession;
import lombok.Data;

import java.util.List;

@Data
public class VoteResult {
    public VoteResult(VoteSession voteSession, List<VoteOptionResult> optionsResults) {
        this.session = voteSession;
        this.optionsResults = optionsResults;
    }

    private List<VoteOptionResult> optionsResults;

    private VoteSession session;
}