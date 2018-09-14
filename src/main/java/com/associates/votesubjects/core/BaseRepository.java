package com.associates.votesubjects.core;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository<T> extends MongoRepository<T, String> {
}
