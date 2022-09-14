package com.antoniomasfanclub.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contact extends Person{

    private static int generatedContacts = 0;

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
