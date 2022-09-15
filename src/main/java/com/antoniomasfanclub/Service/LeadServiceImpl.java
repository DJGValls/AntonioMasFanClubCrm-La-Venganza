package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Lead;
import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public List<Lead> getAll() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getById(Integer id) {
        return this.leadRepository.getLeadById(id);
    }

    @Override
    public Lead save(Lead lead) {
        return (Lead) leadRepository.save(lead);
    }

    @Override
    public Lead update(Lead lead) {
        return (Lead) leadRepository.save(lead);
    }

    @Override
    public void delete(Integer id) {
        leadRepository.delete(leadRepository.getLeadById(id));
    }

    @Override
    public List<SalesRep> getLeadsBySalesRep(SalesRep salesRep) {
        return this.leadRepository.getLeadsBySalesRep(salesRep);
    }
}
