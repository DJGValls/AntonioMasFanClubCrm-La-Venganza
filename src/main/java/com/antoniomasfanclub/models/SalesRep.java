package com.antoniomasfanclub.models;

import com.antoniomasfanclub.models.enums.Colours;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
@Table(name = "SalesRep")
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany
    private Map<Integer, Lead> leads;
    @OneToMany
    private Map<Integer, Opportunity> opportunities;
    //private static int generatedSalesReps = 0;

    public SalesRep() {
    }

    public SalesRep(String name) {
        //this.id = generateId();
        this.name = name;
        this.leads = new HashMap<>();
        this.opportunities = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (opportunity == null) throw new IllegalArgumentException("No valid opportunity selected");
        opportunities.put(opportunity.getId(), opportunity);
    }

    public Opportunity getOpportunity(int id) {
        if (opportunities.get(id) == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        return opportunities.get(id);
    }

    public void deleteOpportunity(int id) {
        Opportunity opportunity = opportunities.get(id);
        if (opportunity == null) throw new IllegalArgumentException("No opportunities found with ID " + id);
        opportunities.remove(id);
    }

    public void addLead(Lead lead) {
        if (lead == null) throw new IllegalArgumentException("No valid lead selected");
        leads.put(lead.getId(), lead);
    }

    public Lead getLead(int id) {
        Lead lead = leads.get(id);
        if (lead == null) throw new IllegalArgumentException("No leads found with ID " + id);
        return leads.get(id);
    }

    public void deleteLead(int id) {
        if (leads.get(id) == null) throw new IllegalArgumentException("No leads found with ID " + id);
        leads.remove(id);
    }

//    public static int getGeneratedSalesReps() {
//        return generatedSalesReps;
//    }
//
//
//    private static int generateId() {
//        return ++generatedSalesReps;
//    }
//
//    public String getSalesRepDetails() {
//        String string = this.toString() + "\n";
//
//        if (leads.isEmpty()) {
//            string += "This sales rep has " + CLI.colourString(Colours.YELLOW, "no leads");
//        } else {
//            string += CLI.colourString(Colours.YELLOW, " Leads:\n");
//            for (Lead lead : leads.values()) {
//                string += "    " + lead + "\n";
//            }
//        }
//
//        if (opportunities.isEmpty()) {
//            string += "This sales rep has " + CLI.colourString(Colours.YELLOW, "no opportunities");
//        } else {
//            string += CLI.colourString(Colours.YELLOW, " Opportunities:\n");
//            for (Opportunity opportunity : opportunities.values()) {
//                string += "    " + opportunity + "\n";
//            }
//        }
//
//        return string;
//    }

    @Override
    public String toString() {
        return CLI.colourString(Colours.BACKGROUND_PURPLE, " 💼 ") + CLI.colourString(Colours.BACKGROUND_CYAN, " 🆔 " + this.getId() + " ") + " " + this.getName();
    }
}
