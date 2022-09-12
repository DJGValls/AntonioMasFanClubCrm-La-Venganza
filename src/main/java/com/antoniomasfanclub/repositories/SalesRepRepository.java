package com.antoniomasfanclub.repositories;

import com.antoniomasfanclub.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {


}
