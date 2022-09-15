package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.model.SalesRep;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.model.enums.Product;
import com.antoniomasfanclub.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    Opportunity getOpportunityById(int id);
    List<Opportunity> findByAccount_Industry(Industry account_industry);
    List<Opportunity> findByAccount_CountryIgnoreCase(String account_country);
    List<Opportunity> findByAccount_CityIgnoreCase(String account_city);
    List<Opportunity> findByProduct(Product product);
    List<Opportunity> findBySalesRep(SalesRep salesRep);
    List<Opportunity> findBySalesRepAndStatus(SalesRep salesRep, Status status);
    List<Opportunity> findByProductAndStatus(Product product, Status status);
    List<Opportunity> findByAccount_IndustryAndStatus(Industry account_industry, Status status);
    List<Opportunity> findByAccount_CityAndStatus(String account_city, Status status);
    List<Opportunity> findByAccount_CountryIgnoreCaseAndStatus(String account_country, Status status);

    @Query("SELECT avg(o.quantity) from Opportunity o")
    Integer getMeanQuantity();
    @Query("SELECT max(o.quantity) from Opportunity o")
    Integer getMaxQuantity();
    @Query("SELECT min(o.quantity) from Opportunity o")
    Integer getMinQuantity();
}
