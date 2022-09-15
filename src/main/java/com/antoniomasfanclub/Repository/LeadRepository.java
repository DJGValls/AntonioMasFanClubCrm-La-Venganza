package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.model.Lead;
import com.antoniomasfanclub.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
    Lead getLeadById(Integer id);
    List<SalesRep> getLeadsBySalesRep(SalesRep salesRep);
}
