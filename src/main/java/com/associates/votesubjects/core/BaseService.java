package com.associates.votesubjects.core;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, U extends BaseRepository<T>>  {

    @Autowired
    protected U repository;

    public T save(final T entity) {
        entity.setCreatedAt(LocalDateTime.now());
        return repository.save(entity);
    }

    public Optional<T> findById(final String id) {
        return repository.findById(id);
    }
}