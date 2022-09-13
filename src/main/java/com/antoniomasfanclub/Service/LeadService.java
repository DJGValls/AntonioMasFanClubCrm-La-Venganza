package com.antoniomasfanclub.Service;

import com.antoniomasfanclub.Model.Lead;

import java.util.List;

public interface LeadService {

    List<Lead> listOfLeads();

    Lead addNewLead(Lead lead);

    void SuprimLead(Lead lead);

}
