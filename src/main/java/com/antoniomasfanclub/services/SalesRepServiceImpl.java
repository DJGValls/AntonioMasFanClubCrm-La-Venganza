package com.antoniomasfanclub.services;

import com.antoniomasfanclub.models.SalesRep;
import com.antoniomasfanclub.repositories.SalesRepRepository;
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


}
