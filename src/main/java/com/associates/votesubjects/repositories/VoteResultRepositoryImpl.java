package com.associates.votesubjects.repositories;

import com.associates.votesubjects.api.models.VoteOptionResult;
import com.associates.votesubjects.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class VoteResultRepositoryImpl implements VoteResultRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public VoteResultRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<VoteOptionResult> findVoteOptionResultsBySessionId(String sessionId) {
        Aggregation agg = newAggregation(
                match(Criteria.where("sessionId").is(sessionId)),
                group("option").count().as("total"),
                project("total").and("option").previousOperation()
        );
        //Convert the aggregation result into a List
        AggregationResults<VoteOptionResult> groupResults = mongoTemplate.aggregate(agg, Vote.class, VoteOptionResult.class);
        return groupResults.getMappedResults();
    }
}
