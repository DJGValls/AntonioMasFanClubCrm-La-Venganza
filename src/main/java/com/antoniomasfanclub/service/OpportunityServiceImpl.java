package com.antoniomasfanclub.service;

import com.antoniomasfanclub.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;
}
