package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepServiceImpl implements SalesRepService  {

    @Autowired
    SalesRepRepository salesRepRepository;

    @Override
    public List<SalesRep> getAll() {
        return salesRepRepository.findAll();
    }

    @Override
    public SalesRep save(SalesRep salesRep) {
        return salesRepRepository.save(salesRep);
    }

    @Override
    public SalesRep update(SalesRep salesRep) {
        return salesRepRepository.save(salesRep);
    }

    @Override
    public SalesRep getById(Integer id) {
        return this.salesRepRepository.getSalesRepById(id);
    }

    @Override
    public void delete(Integer id) {
        this.salesRepRepository.delete(this.salesRepRepository.getSalesRepById(id));
    }

}
