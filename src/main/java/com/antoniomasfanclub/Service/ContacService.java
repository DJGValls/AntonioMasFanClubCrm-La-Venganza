package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Contact;

import java.util.List;

public interface ContacService {

    List<Contact> listOfContacts();

    Contact addNewContact(Contact contact);

    void deleteContact(Contact contact);

}
