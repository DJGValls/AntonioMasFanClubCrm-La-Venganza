package com.antoniomasfanclub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "lead")
public class Lead extends Person {

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SalesRep salesRep;

    public Lead() {
        super();
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super( name, phoneNumber, email, companyName);
    }

    public Lead(Integer id, String name, String phoneNumber, String email, String companyName) {
        super( id, name, phoneNumber, email, companyName);
    }


    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        if (salesRep == null) throw new IllegalArgumentException("No valid sales rep selected");
        this.salesRep = salesRep;
    }

    @Override
    public String toString() {
        return super.toString() + " " +this.getSalesRep();
    }
}
