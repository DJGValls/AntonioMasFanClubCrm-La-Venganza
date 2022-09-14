package com.antoniomasfanclub.model;

import com.antoniomasfanclub.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRM {

    @Autowired
    LeadService leadService;
    @Autowired
    ContactService contactService;
    @Autowired
    AccountService accountService;
    @Autowired
    SalesRepService salesRepService;
    @Autowired
    OpportunityService opportunityService;

    public CRM() {
//        LeadService leadService = new LeadServiceImpl();
//        ContactService contactService = new ContactServiceImpl();
//        AccountService accountService = new AccountServiceImpl();
//        SalesRepService salesRepService = new SalesRepServiceImpl();
//        OpportunityService opportunityService = new OpportunityServiceImpl();
    }

    public void addLead(Lead lead, int salesRepId) {
        if (lead == null)
            throw new IllegalArgumentException("No valid lead was passed");
        SalesRep salesRep = this.salesRepService.getById(salesRepId);

        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);
        salesRep.addLead(lead);
        lead.setSalesRep(salesRep);
        leadService.save(lead);
    }

    public Lead getLead(int id) {
        if (leadService.getById(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        return leadService.getById(id);
    }

    public void deleteLead(int id) {
        Lead lead = leadService.getById(id);
        if (lead == null) throw new IllegalArgumentException("No leads found with ID " + id);
        lead.getSalesRep().deleteLead(id);
        leadService.delete(id);
    }

    public void addContact(Contact contact) {
        contactService.save(contact);
    }

    public Contact getContact(int id) {
        if (contactService.getById(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        return contactService.getById(id);
    }

    public void deleteContact(int id) {
        if (contactService.getById(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        contactService.delete(id);
    }

    public void addOpportunity(Opportunity opportunity, int salesRepId) {
        if (opportunity == null)
            throw new IllegalArgumentException("No valid opportunity was passed");
        SalesRep salesRep = this.salesRepService.getById(salesRepId);
        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);
        salesRep.addOpportunity(opportunity);
        opportunity.setSalesRep(salesRep);
        opportunityService.save(opportunity);
    }

    public Opportunity getOpportunity(int id) {
        if (opportunityService.getById(id) == null)
            throw new IllegalArgumentException("No opportunities found with ID " + id);
        return opportunityService.getById(id);
    }

    public void deleteOpportunity(int id) {
        Opportunity opportunity = this.opportunityService.getById(id);
        if (this.opportunityService.getById(id) == null)
            throw new IllegalArgumentException("No opportunities found with ID " + id);
        opportunity.getSalesRep().deleteOpportunity(id);
        opportunityService.delete(id);
    }

    public void addAccount(Account account) {
        accountService.save(account);
    }

    public Account getAccount(int id) {
        if (accountService.getById(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        return accountService.getById(id);
    }

    public void deleteAccount(int id) {
        if (accountService.getById(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        accountService.delete(id);
    }

    public void showLeads() {
        for (Lead lead : leadService.getAll()) {
            System.out.println("ID: " + lead.getId() + " Name: " + lead);
        }
    }

    public void addSalesRep(SalesRep salesRep) {
        salesRepService.save(salesRep);
    }

    public SalesRep getSalesRep(int id) {
        if (salesRepService.getById(id) == null)
            throw new IllegalArgumentException("No sales reps. found with ID " + id);
        return salesRepService.getById(id);
    }

    public void deleteSalesRep(int id) {
        if (salesRepService.getById(id) == null)
            throw new IllegalArgumentException("No sales reps. found with ID " + id);
        salesRepService.delete(id);
    }

    public List<SalesRep> getSalesReps() {
        return salesRepService.getAll();
    }

    public List<Lead> getLeads() {
        return leadService.getAll();
    }

    public List<Contact> getContacts() {
        return contactService.getAll();
    }

    public List<Opportunity> getOpportunities() {
        return opportunityService.getAll();
    }

    public List<Account> getAccounts() {
        return accountService.getAll();
    }
}
