package com.antoniomasfanclub.models;

public class Lead extends Person {
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

    public static void setGeneratedLeads(int generatedLeads) {
        Lead.generatedLeads = generatedLeads;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    private static int generateId(){
        return ++generatedLeads;
    }
}
