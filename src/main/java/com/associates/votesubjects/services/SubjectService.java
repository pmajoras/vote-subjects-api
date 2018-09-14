package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.core.Utils;
import com.associates.votesubjects.models.Subject;
import com.associates.votesubjects.repositories.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SubjectService extends BaseService<Subject, SubjectRepository> {

    public Optional<Subject> findBySlugOrId(final String slugOrId) {
        return repository.findOneBySlugOrId(slugOrId, slugOrId);
    }

    @Override
    public Subject save(final Subject entity) {
        entity.setSlug(Utils.getSlugFromString(entity.getTitle()));
        return super.save(entity);
    }
}
