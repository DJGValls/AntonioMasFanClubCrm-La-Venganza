package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
}
