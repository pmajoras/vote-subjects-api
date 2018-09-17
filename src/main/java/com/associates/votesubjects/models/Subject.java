package com.associates.votesubjects.models;

import com.associates.votesubjects.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Subject extends BaseEntity {
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @Indexed(name = "slug_index", unique = true)
    private String slug;
}
