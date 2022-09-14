package com.antoniomasfanclub.model;

import com.antoniomasfanclub.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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

    public Lead addLead(Lead lead, Integer salesRepId) {
        if (lead == null)
            throw new IllegalArgumentException("No valid lead was passed");
        SalesRep salesRep = this.salesRepService.getById(salesRepId);

        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);

     //   salesRep.addLead(lead);
        lead.setSalesRep(salesRep);
        return leadService.save(lead);
    }

    public Lead getLead(Integer id) {
        if (leadService.getById(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        return leadService.getById(id);
    }

    public void deleteLead(Integer id) {
        Lead lead = leadService.getById(id);
        if (lead == null) throw new IllegalArgumentException("No leads found with ID " + id);
        lead.getSalesRep().deleteLead(id);
        leadService.delete(id);
    }

    public Contact addContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("No valid contacts passed");
        return contactService.save(contact);
    }

    public Contact getContact(Integer id) {
        if (contactService.getById(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        return contactService.getById(id);
    }

    public void deleteContact(Integer id) {
        if (contactService.getById(id) == null) throw new IllegalArgumentException("No contacts found with ID " + id);
        contactService.delete(id);
    }

    public Opportunity addOpportunity(Opportunity opportunity, Integer salesRepId, Integer accountId) {
        if (opportunity == null)
            throw new IllegalArgumentException("No valid opportunity was passed");
        SalesRep salesRep = this.salesRepService.getById(salesRepId);
        if (salesRep == null)
            throw new IllegalArgumentException("No sales rep could be found in the CRM with ID " + salesRepId);
        Account account = this.accountService.getById(accountId);
        if (account == null)
            throw new IllegalArgumentException("No account could be found in the CRM with ID " + accountId);
        //   salesRep.addOpportunity(opportunity);
        opportunity.setSalesRep(salesRep);
        opportunity.setAccount(account);
        return opportunityService.save(opportunity);
    }

    public Opportunity updateOpportunity(Opportunity opportunity) {
        if (opportunity == null)
            throw new IllegalArgumentException("No valid opportunity was passed");
        return opportunityService.update(opportunity);
    }

    public Opportunity getOpportunity(Integer id) {
        if (opportunityService.getById(id) == null)
            throw new IllegalArgumentException("No opportunities found with ID " + id);
        return opportunityService.getById(id);
    }

    public void deleteOpportunity(Integer id) {
        Opportunity opportunity = this.opportunityService.getById(id);
        if (this.opportunityService.getById(id) == null)
            throw new IllegalArgumentException("No opportunities found with ID " + id);
        opportunity.getSalesRep().deleteOpportunity(id);
        opportunityService.delete(id);
    }

    public Account addAccount(Account account) {
        return accountService.save(account);
    }

    public Account getAccount(Integer id) {
        if (accountService.getById(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        return accountService.getById(id);
    }

    public void deleteAccount(Integer id) {
        if (accountService.getById(id) == null) throw new IllegalArgumentException("No accounts found with ID " + id);
        accountService.delete(id);
    }

    public void showLeads() {
        for (Lead lead : leadService.getAll()) {
            System.out.println("ID: " + lead.getId() + " Name: " + lead);
        }
    }

    public SalesRep addSalesRep(SalesRep salesRep) {
        return salesRepService.save(salesRep);
    }

    public SalesRep getSalesRep(Integer id) {
        if (salesRepService.getById(id) == null)
            throw new IllegalArgumentException("No sales reps. found with ID " + id);
        return salesRepService.getById(id);
    }

    public void deleteSalesRep(Integer id) {
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
