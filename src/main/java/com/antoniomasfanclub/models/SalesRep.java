package com.antoniomasfanclub.models;

import com.antoniomasfanclub.models.enums.Colours;

import java.util.Map;

public class SalesRep {
    private int id;
    private String name;
    private Map<Integer, Lead> leads;
    private Map<Integer, Opportunity> opportunities;

    public SalesRep() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("Names should be at least " + CLI.colourString(Colours.YELLOW, "3 characters") + " long ");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Lead> getLeads() {
        return leads;
    }

    public void setLeads(Map<Integer, Lead> leads) {
        this.leads = leads;
    }

    public Map<Integer, Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Map<Integer, Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public void addOpportunity(Opportunity opportunity) {
        opportunities.put(opportunity.getId(), opportunity);
    }

    public Opportunity getOpportunity(int id) {
        if (opportunities.get(id) == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        return opportunities.get(id);
    }

    public void deleteOpportunity(int id) {
        if (opportunities.get(id) == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        Opportunity opportunity = opportunities.get(id);
        opportunity.getSalesRep().deleteOpportunity(id);
        opportunities.remove(id);
    }
    public void addLead(Lead lead) {
        leads.put(lead.getId(), lead);
    }

    public Lead getLead(int id) {
        if (leads.get(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        Lead lead = leads.get(id);
        lead.getSalesRep().deleteOpportunity(id);
        return leads.get(id);
    }

    public void deleteLead(int id) {
        if (leads.get(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        leads.remove(id);
    }
}
