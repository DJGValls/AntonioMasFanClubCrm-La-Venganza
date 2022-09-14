package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.SalesRep;

import java.util.List;

public interface SalesRepService {

    List<SalesRep> getAll();
    SalesRep save(SalesRep salesRep);
    SalesRep update(SalesRep salesRep);
    SalesRep getById(Integer id);
    void delete(Integer id);

}
