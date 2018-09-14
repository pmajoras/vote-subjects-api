package com.associates.votesubjects.repositories;

import com.associates.votesubjects.core.BaseRepository;
import com.associates.votesubjects.models.Subject;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {
    Optional<Subject> findOneBySlugOrId(String slug, String id);
}
