package com.associates.votesubjects.repositories;

import com.associates.votesubjects.api.models.VoteOptionResult;
import com.associates.votesubjects.models.Vote;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class VoteResultRepositoryImplTests {

    private VoteResultRepository voteResultRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @Before
    public void setup() {
        voteResultRepository = new VoteResultRepositoryImpl(mongoTemplate);
    }

    @Test
    public void findVoteOptionResultsBySessionId_shouldCallAggregateWithMatchBySessionAndGroupByOptions() {
        List<VoteOptionResult> mappedResults = Arrays.asList(new VoteOptionResult(), new VoteOptionResult());
        Document rawResults = new Document();
        AggregationResults<VoteOptionResult> groupResults = new AggregationResults<>(mappedResults, rawResults);
        given(mongoTemplate.aggregate(Mockito.any(Aggregation.class), eq(Vote.class), eq(VoteOptionResult.class))).willReturn(groupResults);

        List<VoteOptionResult> results = voteResultRepository.findVoteOptionResultsBySessionId("1234");
        assertEquals(2, results.size());
    }
}