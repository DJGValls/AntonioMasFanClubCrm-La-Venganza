package com.antoniomasfanclub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends Person{

    @ManyToOne
    @JoinColumn(name = "account", nullable = true)
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "opportunity_id", nullable = true)
    private Opportunity opportunity;

    public Contact(Lead lead) {
        super(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
    }

    public Contact() {
        super();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        account.addContact(this);
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
