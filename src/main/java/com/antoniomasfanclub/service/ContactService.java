package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    Contact getById(Integer id);

    Contact save(Contact contact);

    Contact update(Contact contact);
    void delete(Integer id);

}
