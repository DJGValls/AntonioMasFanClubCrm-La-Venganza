package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.model.enums.Product;
import com.antoniomasfanclub.model.enums.Status;
import com.antoniomasfanclub.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public List<Opportunity> getAll() {
        return this.opportunityRepository.findAll();
    }

    @Override
    public Opportunity getById(Integer id) {
        return this.opportunityRepository.getOpportunityById(id);
    }

    @Override
    public Opportunity save(Opportunity opportunity) {
        return this.opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity update(Opportunity opportunity) {
        return this.opportunityRepository.save(opportunity);
    }

    @Override
    public void delete(Integer id) {
        this.opportunityRepository.delete(this.opportunityRepository.getOpportunityById(id));
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_Industry(Industry account_industry) {
        return this.opportunityRepository.findByAccount_Industry(account_industry);
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_Country(String account_country) {
        return this.opportunityRepository.findByAccount_CountryIgnoreCase(account_country);
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_City(String account_city) {
        return this.opportunityRepository.findByAccount_CityIgnoreCase(account_city);
    }

    @Override
    public List<Opportunity> getOpportunitiesByProduct(Product product) {
        return this.opportunityRepository.findByProduct(product);
    }

    @Override
    public List<Opportunity> getOpportunitiesBySalesRep(SalesRep salesRep) {
        return this.opportunityRepository.findBySalesRep(salesRep);
    }

    @Override
    public List<Opportunity> getOpportunitiesBySalesRepAndStatus(SalesRep salesRep, Status status) {
        return this.opportunityRepository.findBySalesRepAndStatus(salesRep, status);
    }

    @Override
    public List<Opportunity> getOpportunitiesByProductAndStatus(Product product, Status status) {
        return this.opportunityRepository.findByProductAndStatus(product, status);
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_IndustryAndStatus(Industry account_industry, Status status) {
        return this.opportunityRepository.findByAccount_IndustryAndStatus(account_industry, status);
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_CityAndStatus(String account_city, Status status) {
        return this.opportunityRepository.findByAccount_CityAndStatus(account_city, status);
    }

    @Override
    public List<Opportunity> getOpportunitiesByAccount_CountryAndStatus(String account_country, Status status) {
        return this.opportunityRepository.findByAccount_CountryIgnoreCaseAndStatus(account_country, status);
    }

    @Override
    public Integer getMeanQuantity() {
        return this.opportunityRepository.getMeanQuantity();
    }

    @Override
    public Integer getMaxQuantity() {
        return this.opportunityRepository.getMaxQuantity();
    }

    @Override
    public Integer getMinQuantity() {
        return this.opportunityRepository.getMinQuantity();
    }
}
