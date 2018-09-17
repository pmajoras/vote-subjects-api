package com.associates.votesubjects.core;

import com.associates.votesubjects.api.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, U extends BaseRepository<T>>  {
    protected U repository;

    @Autowired
    public BaseService(U repository){
        this.repository = repository;
    }

    public T save(final T entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setCreatedAt(LocalDateTime.now());
        }
        return repository.save(entity);
    }

    public Optional<T> findById(final String id) {
        return repository.findById(id);
    }

    public Page<T> findAllPaged(Pageable pageRequest) {
        pageRequest = pageRequest != null ? pageRequest : PageRequest.of(0, ApiConstants.DEFAULT_PAGE_SIZE);
        return repository.findAll(pageRequest);
    }
}
