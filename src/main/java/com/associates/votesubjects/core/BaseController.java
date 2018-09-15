package com.associates.votesubjects.core;

import com.associates.votesubjects.core.errors.BusinessException;
import com.associates.votesubjects.core.errors.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public abstract class BaseController<T extends BaseEntity, U extends BaseService<T, Z>, Z extends BaseRepository<T>>  {
    protected U service;

    @Autowired
    public BaseController(U service){
        this.service = service;
    }

    @PostMapping("/")
    public T create(@Valid @RequestBody final T entity) {
        entity.setId(null);
        return service.save(entity);
    }

    @GetMapping("/{id}")
    public T getById(@Valid @PathVariable("id") final String id) {
        return service.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

