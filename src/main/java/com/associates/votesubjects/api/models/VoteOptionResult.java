package com.associates.votesubjects.api.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VoteOptionResult {

    @NotNull
    private String option;

    @NotNull
    private long total;
}
