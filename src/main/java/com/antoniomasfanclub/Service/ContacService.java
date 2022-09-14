package com.antoniomasfanclub.Service;

import com.antoniomasfanclub.Model.Contact;
import com.antoniomasfanclub.Model.Lead;

import java.util.List;

public interface ContacService {

    List<Contact> listOfContacts();

    Contact addNewContact(Contact contact);

    void SuprimCoctact(Contact contact);

}
