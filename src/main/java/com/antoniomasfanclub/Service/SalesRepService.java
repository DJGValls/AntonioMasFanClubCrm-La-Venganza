package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.SalesRep;

import java.util.List;

public interface SalesRepService {

    List<SalesRep> findAll();
    SalesRep createSalesRep(String name);

}
