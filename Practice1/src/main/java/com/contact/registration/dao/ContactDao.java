package com.contact.registration.dao;

import com.contact.registration.model.Contact;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 14.04.14
 */
public class ContactDao {
    public List<Contact> getContacts(int number, int offset) throws Exception {
        List<Contact> res = new ArrayList<Contact>();
        File xmlConfig = new File("contacts.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(xmlConfig);

        XPath xPath = XPathFactory.newInstance().newXPath();
        String locator = String.format("/contacts/contact[position() > %d and position() <=%d]", number * offset, (number + 1) * offset);
        NodeList nodes = (NodeList) xPath.evaluate(locator,
                doc.getDocumentElement(), XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); ++i) {
            Element e = (Element) nodes.item(i);
            Contact c = new Contact();
            c.setFirstName(e.getElementsByTagName("firstName").item(0).getTextContent());
            c.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
            c.setCompany(e.getElementsByTagName("company").item(0).getTextContent());
            c.setHobby(e.getElementsByTagName("hobby").item(0).getTextContent());

            res.add(c);
        }
        return res;
    }

    public int getSize(int offset) throws Exception {
        File xmlConfig = new File("contacts.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(xmlConfig);
        int length = doc.getElementsByTagName("contact").getLength();
        int ost = length % offset == 0 ? -1 : 0;
        return length / offset + ost;
    }
}
