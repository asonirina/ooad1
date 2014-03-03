package com.contact.registration.service;


import com.contact.registration.model.Contact;

import javax.servlet.http.HttpServletRequest;

/**
 * User: iason
 * Date: 03.03.14
 */
public class ContactService {

    public static Contact putContact(HttpServletRequest request) {
        Contact contact = getContact(request);
        if (contact == null) {
            contact = new Contact();
        }
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setCompany(request.getParameter("company"));
        contact.setHobby(request.getParameter("hobby"));

        request.getSession().setAttribute("contact", contact);

        return contact;

    }

    public static Contact getContact(HttpServletRequest request) {
        return (Contact) request.getSession().getAttribute("contact");
    }
}
