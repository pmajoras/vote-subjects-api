package com.associates.votesubjects.models;

import com.associates.votesubjects.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class Associate extends BaseEntity {

    @NotNull
    private String name;
}
