package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public List<Opportunity> getAll() {
        return this.opportunityRepository.findAll();
    }

    @Override
    public Opportunity getById(Integer id) {
        return this.opportunityRepository.getOpportunityById(id);
    }

    @Override
    public Opportunity save(Opportunity opportunity) {
        return this.opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity update(Opportunity opportunity) {
        return this.opportunityRepository.save(opportunity);
    }

    @Override
    public void delete(Integer id) {
        this.opportunityRepository.delete(this.opportunityRepository.getOpportunityById(id));
    }
}
