package com.contact.registration.dao;

import com.contact.registration.model.Contact;

import java.util.List;

/**
 * User: iason
 * Date: 05.05.14
 */
public interface BaseDao {
    public List<Contact> list();
    public void update(Contact c);
    public void delete(Contact c);
    public Contact get(String id);

}
