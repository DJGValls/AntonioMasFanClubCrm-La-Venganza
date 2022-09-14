package com.antoniomasfanclub;

import com.antoniomasfanclub.model.*;
import com.antoniomasfanclub.model.enums.Industry;
import com.antoniomasfanclub.model.enums.Product;
import com.antoniomasfanclub.model.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRMTest {

    private CRM crm;
    private Lead lead1;
    private Contact contact1;
    private SalesRep salesRep1;
    private Opportunity opportunity1;
    private Account account1;

    @BeforeEach
    void setUp() {
        crm = new CRM();
        salesRep1 = new SalesRep("Benancio Vendepoco");
        lead1 = new Lead("Perico Palotes", "658987412", "perico@palotes.com", "Palotes Perico");
        contact1 = new Contact(new Lead("Esteban Coestáocupado", "687493822", "esteban@email.com", "BBVA"));
        opportunity1 = new Opportunity(3, Product.FLATBED, Status.OPEN, contact1);
        account1 = new Account(Industry.MANUFACTURING, 135, "Barcelona", "Spain");
        crm.addSalesRep(salesRep1);
    }

    @Test
    void addLead() {
        crm.addLead(lead1, salesRep1.getId());
        assertEquals(lead1.getName(), crm.getLead(lead1.getId()).getName());
        assertEquals(lead1.getName(), salesRep1.getLead(lead1.getId()).getName());
        assertEquals(1, crm.getLeads().size());
    }

    @Test
    void deleteLead() {
        crm.addLead(lead1, salesRep1.getId());
        assertEquals(lead1.getName(), crm.getLead(lead1.getId()).getName());
        assertEquals(lead1.getName(), salesRep1.getLead(lead1.getId()).getName());
        crm.deleteLead(lead1.getId());
        assertTrue(crm.getLeads().isEmpty());
        assertThrows(IllegalArgumentException.class, () -> crm.getLead(lead1.getId()));
        assertThrows(IllegalArgumentException.class, () -> salesRep1.getLead(lead1.getId()));
    }

    @Test
    void getLead() {
        assertThrows(IllegalArgumentException.class, () -> crm.getLead(4));
    }

    @Test
    void addContact() {
        crm.addContact(contact1);
        assertEquals("Esteban Coestáocupado", contact1.getName());
        assertEquals(1, crm.getContacts().size());
    }

    @Test
    void deleteContact() {
        crm.addContact(contact1);
        crm.deleteContact(contact1.getId());
        assertTrue(crm.getContacts().isEmpty());
    }

    @Test
    void getContact() {
        assertThrows(IllegalArgumentException.class, () -> crm.getContact(4));
    }

    @Test
    void addOpportunity() {
        crm.addOpportunity(opportunity1, salesRep1.getId());
        assertEquals(3, opportunity1.getQuantity());
        assertEquals(1, crm.getOpportunities().size());
    }

    @Test
    void deleteOpportunity() {
        crm.addOpportunity(opportunity1, salesRep1.getId());
        assertEquals(opportunity1, crm.getOpportunity(opportunity1.getId()));
        assertEquals(opportunity1, salesRep1.getOpportunity(opportunity1.getId()));
        crm.deleteOpportunity(opportunity1.getId());
        assertTrue(crm.getOpportunities().isEmpty());
        assertThrows(IllegalArgumentException.class, () -> crm.getOpportunity(opportunity1.getId()));
        assertThrows(IllegalArgumentException.class, () -> salesRep1.getOpportunity(opportunity1.getId()));
    }

    @Test
    void getOpportunity() {
        assertThrows(IllegalArgumentException.class, () -> crm.getOpportunity(4));
    }

    @Test
    void addAccount() {
        crm.addAccount(account1);
        assertEquals(135, account1.getEmployeeCount());
        assertEquals(1, crm.getAccounts().size());
    }

    @Test
    void deleteAccount() {
        crm.addAccount(account1);
        crm.deleteAccount(account1.getId());
        assertTrue(crm.getAccounts().isEmpty());
    }

    @Test
    void getAccount() {
        assertThrows(IllegalArgumentException.class, () -> crm.getAccount(4));
    }
}
