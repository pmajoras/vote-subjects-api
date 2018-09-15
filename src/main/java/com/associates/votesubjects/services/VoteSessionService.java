package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.core.errors.BusinessException;
import com.associates.votesubjects.models.VoteSession;
import com.associates.votesubjects.repositories.SubjectRepository;
import com.associates.votesubjects.repositories.VoteSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteSessionService extends BaseService<VoteSession, VoteSessionRepository> {
    private final SubjectRepository subjectRepository;

    @Autowired
    public VoteSessionService(VoteSessionRepository repository, SubjectRepository subjectRepository){
        super(repository);
        this.subjectRepository = subjectRepository;
    }

    @Override
    public VoteSession save(final VoteSession entity) {
        if (entity.getExpiresAt() == null || entity.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Expiration date must be after current date.");
        }

        subjectRepository.findById(entity.getSubjectId()).orElseThrow(() -> new BusinessException("The subjectId is invalid"));

        return super.save(entity);
    }
}
