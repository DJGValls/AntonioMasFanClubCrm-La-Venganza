package com.antoniomasfanclub.Service;

import com.antoniomasfanclub.Model.Lead;
import com.antoniomasfanclub.Repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeadServiceImpl implements LeadService{

    private LeadRepository leadRepository;

    @Override
    public List<Lead> listOfLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead addNewLead(Lead lead) {
        return (Lead) leadRepository.save(lead);
    }

    @Override
    public void SuprimLead(Lead lead) {
        leadRepository.delete(lead);
    }
}
