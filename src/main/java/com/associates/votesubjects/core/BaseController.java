package com.associates.votesubjects.core;

import com.associates.votesubjects.api.errors.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/")
    public Page<T> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "100") int size) {
        size = size >= 1 ? size : 100;
        page = page > 0 ? page : 1;
        return service.findAllPaged(PageRequest.of(page - 1, size));
    }
}

