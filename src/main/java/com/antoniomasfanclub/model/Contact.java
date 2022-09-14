package com.antoniomasfanclub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "contact")
public class Contact extends Person{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @OneToOne
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
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
