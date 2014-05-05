package com.contact.registration.dao;

import com.contact.registration.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: iason
 * Date: 05.05.14
 */
public class ConcreteDao implements BaseDao {
    List<Contact> contacts = new ArrayList<Contact>();
   private static BaseDao dao;

    public static BaseDao getInstance() {
        if (dao == null) {
            dao = new ConcreteDao();
        }
        return dao;
    }

    private ConcreteDao() {
      contacts.add(new Contact());
    }

    @Override
    public List<Contact> list() {
        return contacts;
    }

    @Override
    public void update(Contact c) {
        contacts.remove(c);
        contacts.add(c);
    }

    @Override
    public void delete(Contact c) {
        contacts.remove(c);
    }

    @Override
    public Contact get(String id) {
        Contact c = new Contact();
        c.setId(id);
        int index = contacts.indexOf(c);
        if(index==-1) {
            return null;
        } else {
            return contacts.get(index);
        }
    }

    public static void main(String[] args) {
        BaseDao dao1 =  ConcreteDao.getInstance();

        Contact c = dao1.list().get(0);

        Contact c1 = new Contact();
        c1.setId(c.getId());
        c1.setCompany("hjkhkhj");
        dao1.update(c1);
        System.out.println();

    }
}
