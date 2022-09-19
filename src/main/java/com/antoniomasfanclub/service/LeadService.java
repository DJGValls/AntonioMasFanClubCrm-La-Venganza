package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Lead;
import com.antoniomasfanclub.model.SalesRep;

import java.util.List;

public interface LeadService {

    List<Lead> getAll();
    Lead getById(Integer id);
    Lead save(Lead lead);
    Lead update(Lead lead);
    void delete(Integer id);
    List<SalesRep> getLeadsBySalesRep(SalesRep salesRep);

}
