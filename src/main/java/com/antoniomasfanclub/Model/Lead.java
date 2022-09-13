package com.antoniomasfanclub.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leads")
public class Lead extends Person {
    @Id
    private static int generatedLeads = 0;
    private SalesRep salesRep;

    public Lead() {
        super(generateId());
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(generateId(), name, phoneNumber, email, companyName);
    }

    public static int getGeneratedLeads() {
        return generatedLeads;
    }
/*
    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        if (salesRep == null) throw new IllegalArgumentException("No valid sales rep selected");
        this.salesRep = salesRep;
    }
*/

    private static int generateId() {
        return ++generatedLeads;
    }

    /*
    @Override
    public String toString() {
        return super.toString() + " " +this.getSalesRep();
    }
    */
}
