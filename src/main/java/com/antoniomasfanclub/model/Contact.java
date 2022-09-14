package com.antoniomasfanclub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends Person{

    private static int generatedContacts = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @OneToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;

    public Contact(Lead lead) {
        super(generateId(), lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
    }

    public Contact() {
        super();
    }

    private static int generateId(){
        return ++generatedContacts;
    }

    public static int getGeneratedContacts() {
        return generatedContacts;
    }
}
