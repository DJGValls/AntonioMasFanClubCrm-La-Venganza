package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Opportunity;

import java.util.List;

public interface OpportunityService {

    public List<Opportunity> getAll();
    public Opportunity getById(Integer id);
    public Opportunity save(Opportunity opportunity);
    public Opportunity update(Opportunity opportunity);
    public void delete(Integer id);
}
