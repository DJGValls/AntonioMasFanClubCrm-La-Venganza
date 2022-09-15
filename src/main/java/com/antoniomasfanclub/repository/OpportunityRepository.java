package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.model.enums.Product;
import com.antoniomasfanclub.model.enums.Status;
import com.antoniomasfanclub.service.OpportunityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    Opportunity getOpportunityById(int id);
    List<Opportunity> getOpportunitiesByAccount_Industry(Industry account_industry);
    List<Opportunity> getOpportunitiesByAccount_City(String account_city);
    List<Opportunity> getOpportunitiesByProduct(Product product);
    List<Opportunity> getOpportunitiesBySalesRep(SalesRep salesRep);
    List<Opportunity> getOpportunitiesBySalesRepAndStatus(SalesRep salesRep, Status status);
    List<Opportunity> getOpportunitiesByProductAndStatus(Product product, Status status);
    List<Opportunity> getOpportunitiesByAccount_IndustryAndStatus(Industry account_industry, Status status);
    List<Opportunity> getOpportunitiesByAccount_CityAndStatus(String account_city, Status status);
    List<Opportunity> getOpportunitiesByAccount_CountryAndStatus(String account_country, Status status);

    @Query("SELECT avg(o.quantity) from Opportunity o")
    Integer getMeanQuantity();
    @Query("SELECT max(o.quantity) from Opportunity o")
    Integer getMaxQuantity();
    @Query("SELECT min(o.quantity) from Opportunity o")
    Integer getMinQuantity();
}
