package com.contact.registration.servlet;

import com.contact.registration.command.Command;
import com.contact.registration.factory.CommandFactory;
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
        }

        Command command = CommandFactory.getCommandByAction(action);
        command.processPage(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

}


