package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {
    SalesRep getSalesRepById(Integer id);
}
