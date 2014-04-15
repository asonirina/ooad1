package com.contact.registration.service;

/**
 * User: iason
 * Date: 07.04.14
 */

import javax.xml.parsers.*;

import com.contact.registration.model.Contact;
import org.w3c.dom.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContactXmlService {

    public Document produceDOMDocument(Contact contact) throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element contacts = doc.createElement("contacts");
        doc.appendChild(contacts);

        Element contactElem = doc.createElement("contact");
        contacts.appendChild(contactElem);


        addElem(doc, contactElem, "firstName", contact.getFirstName());
        addElem(doc, contactElem, "lastName", contact.getLastName());
        addElem(doc, contactElem, "company", contact.getCompany());
        addElem(doc, contactElem, "hobby", contact.getHobby());

        return doc;
    }

    public Document produceDOMDocument(List<Contact> contacts, int page) throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element root = doc.createElement("contacts");
        doc.appendChild(root);
        for (Contact contact : contacts) {
            Element contactElem = doc.createElement("contact");
            root.appendChild(contactElem);


            addElem(doc, contactElem, "firstName", contact.getFirstName());
            addElem(doc, contactElem, "lastName", contact.getLastName());
            addElem(doc, contactElem, "company", contact.getCompany());
            addElem(doc, contactElem, "hobby", contact.getHobby());
        }

        addElem(doc, root, "page", String.valueOf(page+1));


        return doc;
    }

    public Document addToDOMDocument(Contact contact, File f) throws Exception {

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(f);


        Node contacts = doc.getElementsByTagName("contacts").item(0);

        Element contactElem = doc.createElement("contact");
        contacts.appendChild(contactElem);

        addElem(doc, contactElem, "firstName", contact.getFirstName());
        addElem(doc, contactElem, "lastName", contact.getLastName());
        addElem(doc, contactElem, "company", contact.getCompany());
        addElem(doc, contactElem, "hobby", contact.getHobby());

        return doc;
    }

    private void addElem(Document doc, Element parent, String elemName,
                         String elemValue) {
        Element elem = doc.createElement(elemName);
        elem.appendChild(doc.createTextNode(elemValue));
        parent.appendChild(elem);
    }
}
