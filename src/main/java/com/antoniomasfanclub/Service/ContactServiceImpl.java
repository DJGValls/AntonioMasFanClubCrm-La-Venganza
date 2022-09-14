package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Contact;
import com.antoniomasfanclub.model.Lead;
import com.antoniomasfanclub.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(Integer id) {
        return this.contactRepository.getReferenceById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return (Contact) contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return (Contact) contactRepository.save(contact);
    }
    @Override
    public void delete(Integer id) {
        contactRepository.delete(contactRepository.getReferenceById(id));
    }
}
