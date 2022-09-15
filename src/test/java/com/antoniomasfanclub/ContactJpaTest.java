package com.antoniomasfanclub;

import com.antoniomasfanclub.model.Account;
import com.antoniomasfanclub.model.Contact;
import com.antoniomasfanclub.model.Lead;
import com.antoniomasfanclub.model.Opportunity;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.repository.AccountRepository;
import com.antoniomasfanclub.repository.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ContactJpaTest {

    Contact contact;
    Account account;

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        contact = new Contact(new Lead("Test", "111222333", "ejejeje@gmail.com", "satania"));
        account = new Account(Industry.MEDICAL, 12, "String city", "String country");
    }

    @Test
    void contactAndAccountAssociationTest() {
        Account dbAccount = this.accountRepository.save(account);
        contact.setAccount(this.accountRepository.save(account));
        Contact dbContact = this.contactRepository.save(contact);
        Assertions.assertNotNull(dbContact.getId());
    }

}
