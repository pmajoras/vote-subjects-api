package com.associates.votesubjects.models;

import com.associates.votesubjects.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class Subject extends BaseEntity {
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private String slug;
}
