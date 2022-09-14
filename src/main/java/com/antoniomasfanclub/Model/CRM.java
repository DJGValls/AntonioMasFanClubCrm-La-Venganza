package com.antoniomasfanclub.Model;

import java.util.HashMap;
import java.util.Map;

public class CRM {
    Map<Integer, Lead> leads;
    Map<Integer, SalesRep> salesReps;
    Map<Integer, Contact> contacts;
    Map<Integer, Account> accounts;
    Map<Integer, Opportunity> opportunities;

    public CRM() {
        this.leads = new HashMap<>();
        this.contacts = new HashMap<>();
        this.accounts = new HashMap<>();
        this.salesReps = new HashMap<>();
        this.opportunities = new HashMap<>();
    }
/*
    public void addLead(Lead lead, int salesRepId) {
        if (lead == null)
            throw new IllegalArgumentException("No valid lead was passed");
        SalesRep salesRep = this.salesReps.get(salesRepId);
        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);
        salesRep.addLead(lead);
        lead.setSalesRep(salesRep);
        leads.put(lead.getId(), lead);
    }

    public Lead getLead(int id) {
        if (leads.get(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        return leads.get(id);
    }

    public void deleteLead(int id) {
        Lead lead = leads.get(id);
        if (lead == null) throw new IllegalArgumentException("No leads found with ID " + id);
        lead.getSalesRep().deleteLead(id);
        leads.remove(id);
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    public Contact getContact(int id) {
        if (contacts.get(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        return contacts.get(id);
    }

    public void deleteContact(int id) {
        if (contacts.get(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        contacts.remove(id);
    }

 */

    public void addOpportunity(Opportunity opportunity, int salesRepId) {
        if (opportunity == null)
            throw new IllegalArgumentException("No valid opportunity was passed");
        SalesRep salesRep = this.salesReps.get(salesRepId);
        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);
        salesRep.addOpportunity(opportunity);
        opportunity.setSalesRep(salesRep);
        opportunities.put(opportunity.getId(), opportunity);
    }

    public Opportunity getOpportunity(int id) {
        if (opportunities.get(id) == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        return opportunities.get(id);
    }

    public void deleteOpportunity(int id) {
        Opportunity opportunity = this.opportunities.get(id);
        if (this.opportunities.get(id) == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        opportunity.getSalesRep().deleteOpportunity(id);
        opportunities.remove(id);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account getAccount(int id) {
        if (accounts.get(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        return accounts.get(id);
    }

    public void deleteAccount(int id) {
        if (accounts.get(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        accounts.remove(id);
    }

    public void showLeads() {
        for (Integer id : leads.keySet()) {
            System.out.println("ID: " + id + " Name: " + leads.get(id));
        }
    }

    public Map<Integer, SalesRep> getSalesReps() {
        return salesReps;
    }

    public void setSalesReps(Map<Integer, SalesRep> salesReps) {
        this.salesReps = salesReps;
    }

    public void addSalesRep(SalesRep salesRep) {
        salesReps.put(salesRep.getId(), salesRep);
    }

    public SalesRep getSalesRep(int id) {
        if (salesReps.get(id) == null) throw new IllegalArgumentException("No sales reps. found with ID " + id);
        return salesReps.get(id);
    }

    public void deleteSalesRep(int id) {
        if (salesReps.get(id) == null) throw new IllegalArgumentException("No sales reps. found with ID " + id);
        salesReps.remove(id);
    }

    public Map<Integer, Lead> getLeads() {
        return leads;
    }

    public Map<Integer, Contact> getContacts() {
        return contacts;
    }


    public Map<Integer, Opportunity> getOpportunities() {
        return opportunities;
    }


    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
