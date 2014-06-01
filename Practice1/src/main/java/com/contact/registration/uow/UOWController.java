package com.contact.registration.uow;

import com.contact.registration.dao.BaseDao;
import com.contact.registration.dao.ConcreteDao;
import com.contact.registration.model.Contact;
import com.contact.registration.utils.ContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 05.05.14
 */
public class UOWController {
    private static UOWController instance;
    List<Contact> sourceObjects;
    List<Contact> changedObjects;
    private BaseDao dao = ConcreteDao.getInstance();
    private int offset = 3;

    public static UOWController getInstance() {
        if (instance == null) {
            instance = new UOWController();
        }
        return instance;
    }

    private UOWController() {
        sourceObjects = new ArrayList<Contact>();
        changedObjects = new ArrayList<Contact>();
    }

    public void load(Contact c) {
        sourceObjects.add((Contact) c.clone());
        changedObjects.add(c);
    }

    public void commit() {

        for (Contact c : changedObjects) {
            int index = sourceObjects.indexOf(c);
            if (index < 0) {
                dao.delete(c);
            } else {
                Contact c1 = sourceObjects.get(index);
                if(!ContactUtils.compareFields(c,c1)){
                    dao.update(c);
                }
            }
        }
    }

    public int getSize() {
        int length = dao.list().size();
        int ost = length % offset == 0 ? -1 : 0;
        return length / offset + ost;
    }

    public List<Contact> getByPage(int page) {
       List<Contact> contactList = dao.list();
        List<Contact> res = new ArrayList<Contact>();
        for (int i = page*offset; i<offset*(page+1)|| i<contactList.size(); i++) {
           res.add(contactList.get(i));
        }
        return res;
    }
}
