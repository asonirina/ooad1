package com.contact.registration.utils;

import com.contact.registration.model.Contact;

/**
 * User: iason
 * Date: 05.05.14
 */
public class ContactUtils {
    public static boolean compareFields(Contact c1, Contact c2) {
        return c1.getFirstName().equals(c2.getFirstName()) &&
                c1.getLastName().equals(c2.getLastName()) &&
                c1.getCompany().equals(c2.getCompany())&&
                c1.getHobby().equals(c2.getHobby());
    }
}
