package com.contact.registration.service;


import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.model.Contact;
import com.contact.registration.uow.UOWController;

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
            UOWController.getInstance().load(contact);
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if (firstName != null && lastName != null) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
        }
        String company = request.getParameter("company");
        if (company != null) {
            contact.setCompany(company);
        }
        String hobby = request.getParameter("hobby");
        if (hobby != null) {
            contact.setHobby(hobby);
        }

        request.getSession().setAttribute("contact", contact);

        return contact;

    }

    public static Contact getContact(HttpServletRequest request) {
        return (Contact) request.getSession().getAttribute("contact");
    }
}
