package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Lead;

import java.util.List;

public interface LeadService {

    List<Lead> listOfLeads();

    Lead addNewLead(Lead lead);

    void deleteLead(Lead lead);

}
