package com.contact.registration.command;

import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;
import com.contact.registration.service.ContactXmlService;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;

/**
 * User: iason
 * Date: 17.03.14
 */
public abstract class Command {
    protected TransformerFactory transFact = TransformerFactory.newInstance();
    protected ContactXmlService service = new ContactXmlService();
    protected Templates template;
    protected Templates errorTemplate;

    public Command() throws Exception {
        errorTemplate = transFact.newTemplates(
                new StreamSource(new FileInputStream("C:/Users/iason/ooad1/Practice1/src/main/webapp/xsl/error.xslt")));
    }

    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contact contact = ContactService.getContact(request);
        try {
            Document domDoc = service.produceDOMDocument(contact);
            template.newTransformer().transform(new DOMSource(domDoc), new StreamResult(response.getWriter()));
        } catch (Exception ex) {
            doError(request, response);
        }
    }

    public void doError(HttpServletRequest request, HttpServletResponse response) {
        try {
            errorTemplate.newTransformer().transform(new DOMSource(), new StreamResult(response.getWriter()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
