package com.contact.registration.command;

import com.contact.registration.dao.ContactDao;
import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * User: iason
 * Date: 17.03.14
 */
public class ViewCommand extends Command {

    ContactDao dao = new ContactDao();
    private final int OFFSET = 3;

    public ViewCommand() throws Exception {
        super();
        template = transFact.newTemplates(
                new StreamSource(new FileInputStream("C:/Users/iason/work/ooad1/Practice1/src/main/webapp/xsl/final.xslt")));
    }

    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int page = request.getParameter("page") == null ? 0 : Integer.parseInt(request.getParameter("page")) - 1;
        if (request.getParameter("Next") != null) {
            if (page < dao.getSize(OFFSET)) {
                page++;
            }
        } else {
            if (request.getParameter("Back") != null) {
                if (page >= 1) {
                    page--;
                }
            }
        }
        List<Contact> contacts = dao.getContacts(page, OFFSET);
        try {
            Document domDoc = service.produceDOMDocument(contacts, page);
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
