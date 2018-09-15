package com.associates.votesubjects.services;

import com.associates.votesubjects.core.BaseService;
import com.associates.votesubjects.models.Associate;
import com.associates.votesubjects.repositories.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AssociateService extends BaseService<Associate, AssociateRepository> {

    @Autowired
    public AssociateService(AssociateRepository repository){
        super(repository);
    }
}
