package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepServiceImpl implements SalesRepService{

    @Autowired
    SalesRepRepository salesRepRepository;


    @Override
    public List<SalesRep> findAll() {
        return salesRepRepository.findAll();
    }

    @Override
    public SalesRep createSalesRep(String name) {
        SalesRep newSalesRep = new SalesRep(name);
        return salesRepRepository.save(newSalesRep);
    }

}
