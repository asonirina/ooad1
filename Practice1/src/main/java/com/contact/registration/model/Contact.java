package com.contact.registration.model;

/**
 * User: iason
 * Date: 01.03.14
 */
public class Contact {
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
}
