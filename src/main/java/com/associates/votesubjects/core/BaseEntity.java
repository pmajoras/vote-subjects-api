package com.associates.votesubjects.core;

import com.associates.votesubjects.api.ApiConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {

    @Id
    private String id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = ApiConstants.DATE_PATTERN)
    private LocalDateTime createdAt;
}
