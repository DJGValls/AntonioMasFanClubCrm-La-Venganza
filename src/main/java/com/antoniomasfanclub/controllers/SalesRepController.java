package com.antoniomasfanclub.controllers;

import com.antoniomasfanclub.models.SalesRep;
import com.antoniomasfanclub.services.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesRepController {

    @Autowired
    SalesRepService salesRepService;

    //Method to get a list of all SalesReps
    @GetMapping("/salesReps")
    public List<SalesRep> listSalesReps(){
        return salesRepService.findAll();
    }
}
