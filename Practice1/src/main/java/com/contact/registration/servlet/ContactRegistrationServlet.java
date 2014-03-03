package com.contact.registration.servlet;

import com.contact.registration.model.Contact;
import com.contact.registration.service.ContactService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContactRegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);
        if (action != null && action.length() > 0) {
            session.setAttribute("action", action);

            if ("aCompany".equals(action)) {
                processPageCompany(request, response);
            } else if ("aPersonalInfo".equals(action)) {
                processPagePersonal(request, response);
            } else if ("aSave".equals(action)) {
                processPageFinal(request, response);
            }

        } else {
            request.getRequestDispatcher("first_last.jsp").forward(request, response);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


    private void processPageCompany (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = ContactService.putContact(request);
        request.setAttribute("firstName", contact.getFirstName());
        request.setAttribute("lastName", contact.getLastName());
        request.getRequestDispatcher("company.jsp").forward(request, response);
    }

    private void processPagePersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = ContactService.putContact(request);
        request.setAttribute("firstName",contact.getFirstName());
        request.setAttribute("lastName",contact.getLastName());
        request.setAttribute("company",contact.getCompany());
        request.getRequestDispatcher("personal.jsp").forward(request, response);
    }

    private void processPageFinal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService.putContact(request);
        request.getRequestDispatcher("final.jsp").forward(request, response);
    }

}


