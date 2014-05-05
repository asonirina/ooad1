package com.contact.registration.model;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * User: iason
 * Date: 01.03.14
 */
public class Contact implements Cloneable{
    private String id = RandomStringUtils.random(10, true, true);
    private String firstName;
    private String lastName;
    private String company;
    private String hobby;

    public String getFirstName() {
        return firstName != null ? firstName : "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName != null ? lastName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company != null ? company : "";
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHobby() {
        return hobby != null ? hobby : "";
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public Object clone() {
        Contact c = new Contact();
        c.setId(id);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setCompany(company);
        c.setHobby(hobby);
        return c;
    }
}
