package com.antoniomasfanclub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends Person{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @OneToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;

    public Contact(Lead lead) {
        super(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
    }

    public Contact() {
        super();
    }

}
