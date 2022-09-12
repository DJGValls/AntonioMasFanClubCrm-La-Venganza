package com.antoniomasfanclub.models.controller;

import com.antoniomasfanclub.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpportunityController {

    @Autowired
    OpportunityService opportunityService;
}
