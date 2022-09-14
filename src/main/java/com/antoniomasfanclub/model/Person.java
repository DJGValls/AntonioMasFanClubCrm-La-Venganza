package com.antoniomasfanclub.model;

import com.antoniomasfanclub.model.enums.Colours;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, String phoneNumber, String email, String companyName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("Names should be at least " + CLI.colour(Colours.YELLOW, "3 characters") + " long ");
        this.name = name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
//        Regex patterns to account for simple phone numbers
        if (phoneNumber.matches("\\d{9}"))
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("☎️ Phone numbers must have " + CLI.colour(Colours.YELLOW, "9 numbers") + " with " + CLI.colour(Colours.YELLOW, "no separators"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("^(.+)@(\\S+)$")) this.email = email.trim();
        else
            throw new IllegalArgumentException("✉️ Emails must follow the " + CLI.colour(Colours.YELLOW, "xxx@yyy.zzz") + "format");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null || companyName.trim().length() < 3)
            throw new IllegalArgumentException("🏢 Company names should be at least " + CLI.colour(Colours.YELLOW, "3 characters") + " long ");
        this.companyName = companyName.trim();
    }

    @Override
    public String toString() {
        return CLI.colour(Colours.BACKGROUND_CYAN, " 🆔 " + this.getId()+" ") + " " +
                this.getName() + " 🏢 " + this.getCompanyName() + " ✉️ " + this.getEmail() + " ☎️ " + this.getPhoneNumber();
    }
}
