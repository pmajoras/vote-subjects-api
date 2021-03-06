package com.associates.votesubjects.models;

import com.associates.votesubjects.api.ApiConstants;
import com.associates.votesubjects.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class VoteSession extends BaseEntity {
    public VoteSession() {
        setExpiresAt(LocalDateTime.now().plusMinutes(1));
    }

    @NotNull
    private String subjectId;

    @JsonFormat(pattern = ApiConstants.DATE_PATTERN)
    private LocalDateTime expiresAt;

    @Transient
    public Boolean isExpired() {
        return getExpiresAt() == null || LocalDateTime.now().isAfter(getExpiresAt());
    }
}
