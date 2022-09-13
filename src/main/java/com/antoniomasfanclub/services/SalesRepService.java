package com.antoniomasfanclub.services;

import com.antoniomasfanclub.models.Opportunity;
import com.antoniomasfanclub.models.SalesRep;
import com.antoniomasfanclub.repositories.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalesRepService {

    List<SalesRep> findAll();
    SalesRep createSalesRep(SalesRep salesRep);

}
