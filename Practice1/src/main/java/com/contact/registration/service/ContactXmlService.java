package com.contact.registration.service;

/**
 * User: iason
 * Date: 07.04.14
 */

import javax.xml.parsers.*;

import com.contact.registration.model.Contact;
import org.w3c.dom.*;

public class ContactXmlService {

    public Document produceDOMDocument(Contact contact) throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element contactElem = doc.createElement("contact");
        doc.appendChild(contactElem);

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
