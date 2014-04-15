package com.contact.registration.command;

import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;
import org.w3c.dom.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * User: iason
 * Date: 17.03.14
 */
public class PersonalCommand extends Command {

    public PersonalCommand() throws Exception {
        super();
        template = transFact.newTemplates(
                new StreamSource(new FileInputStream("C:/Users/iason/work/ooad1/Practice1/src/main/webapp/xsl/hobby.xslt")));
    }
//    @Override
//    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Contact contact = ContactService.getContact(request);
//        request.setAttribute("firstName",contact.getFirstName());
//        request.setAttribute("lastName",contact.getLastName());
//        request.setAttribute("company",contact.getCompany());
//        request.getRequestDispatcher("personal.jsp").forward(request, response);
//
//    }
}
