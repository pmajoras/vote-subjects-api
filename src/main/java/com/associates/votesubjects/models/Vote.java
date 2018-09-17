package com.associates.votesubjects.models;

import com.associates.votesubjects.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@CompoundIndex(name = "associate_session_index", def = "{'associateId': 1, 'sessionId': 1}", unique = true)
public class Vote extends BaseEntity {

    @NotNull
    private String associateId;

    @NotNull
    private String sessionId;

    @NotNull
    @Pattern(regexp = "yes|no")
    private String option;

    @JsonIgnore
    public Boolean isOptionValid() {
        List<String> validOptions = Arrays.asList("yes", "no");
        return validOptions.contains(getOption());
    }
}