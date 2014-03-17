package com.contact.registration.command;

import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: iason
 * Date: 17.03.14
 */
public class PersonalCommand implements Command{
    @Override
    public void processPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = ContactService.putContact(request);
        request.setAttribute("firstName",contact.getFirstName());
        request.setAttribute("lastName",contact.getLastName());
        request.setAttribute("company",contact.getCompany());
        request.getRequestDispatcher("personal.jsp").forward(request, response);
    }
}
