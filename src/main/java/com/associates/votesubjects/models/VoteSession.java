package com.associates.votesubjects.models;

import com.associates.votesubjects.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class VoteSession extends BaseEntity {

    @NotNull
    private String subjectId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime expiresAt;
}
