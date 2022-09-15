package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.model.enums.Product;
import com.antoniomasfanclub.model.enums.Status;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpportunityService {

    List<Opportunity> getAll();
    Opportunity getById(Integer id);
    Opportunity save(Opportunity opportunity);
    Opportunity update(Opportunity opportunity);
    void delete(Integer id);
    List<Opportunity> getOpportunitiesByAccount_Industry(Industry account_industry);
    List<Opportunity> getOpportunitiesByAccount_Country(String account_country);
    List<Opportunity> getOpportunitiesByAccount_City(String account_city);
    List<Opportunity> getOpportunitiesByProduct(Product product);
    List<Opportunity> getOpportunitiesBySalesRep(SalesRep salesRep);
    List<Opportunity> getOpportunitiesBySalesRepAndStatus(SalesRep salesRep, Status status);
    List<Opportunity> getOpportunitiesByProductAndStatus(Product product, Status status);
    List<Opportunity> getOpportunitiesByAccount_IndustryAndStatus(Industry account_industry, Status status);
    List<Opportunity> getOpportunitiesByAccount_CityAndStatus(String account_city, Status status);
    List<Opportunity> getOpportunitiesByAccount_CountryAndStatus(String account_country, Status status);
    Integer getMeanQuantity();
    Integer getMaxQuantity();
    Integer getMinQuantity();

}
