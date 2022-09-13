package com.antoniomasfanclub.Service;

import com.antoniomasfanclub.Model.Contact;
import com.antoniomasfanclub.Repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContacService{

    private ContactRepository contactRepository;


    @Override
    public List<Contact> listOfContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact addNewContact(Contact contact) {
        return (Contact) contactRepository.save(contact);
    }

    @Override
    public void SuprimCoctact(Contact contact) {
        contactRepository.delete(contact);

    }
}
