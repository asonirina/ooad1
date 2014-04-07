package com.contact.registration.command;

import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * User: iason
 * Date: 17.03.14
 */
public class FinalCommand extends Command {

    public FinalCommand() throws Exception {
        super();
        template = transFact.newTemplates(
                new StreamSource(new FileInputStream("C:/Users/iason/ooad1/Practice1/src/main/webapp/xsl/final.xslt")));
    }
//    @Override
//    public void processPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.getRequestDispatcher("final.jsp").forward(request, response);
//    }
}
