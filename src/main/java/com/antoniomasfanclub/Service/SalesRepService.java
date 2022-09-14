package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.SalesRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalesRepService {

    List<SalesRep> findAll();
    SalesRep createSalesRep(String name);

}
