package com.contact.registration.command;

import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;
import com.contact.registration.uow.UOWController;
import org.w3c.dom.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * User: iason
 * Date: 17.03.14
 */
public class FinalCommand extends Command {

//    ContactDao dao = new ContactDao();
    private final int OFFSET = 3;

    public FinalCommand() throws Exception {
        super();
        template = transFact.newTemplates(
                new StreamSource(new FileInputStream("C:/Users/iason/work/ooad1/Practice1/src/main/webapp/xsl/final.xslt")));
    }

    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contact contact = ContactService.getContact(request);
        UOWController.getInstance().commit();

        File f = new File("contacts.xml");
            Document saveDoc = service.addToDOMDocument(contact, f);

            TransformerFactory tFactory =
                    TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DOMSource source = new DOMSource(saveDoc);
            StreamResult result = new StreamResult(new FileOutputStream(f, false));
            transformer.transform(source, result);
        List<Contact> contacts = UOWController.getInstance().getByPage(0);
        try {
            Document domDoc = service.produceDOMDocument(contacts, 0);
            template.newTransformer().transform(new DOMSource(domDoc), new StreamResult(response.getWriter()));
        } catch (Exception ex) {
            doError(request, response);
        }
    }
//    @Override
//    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.getRequestDispatcher("final.jsp").forward(request, response);
//    }
}
