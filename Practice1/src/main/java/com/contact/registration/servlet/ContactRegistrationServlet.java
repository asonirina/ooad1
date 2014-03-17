package com.contact.registration.servlet;

import com.contact.registration.command.Command;
import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.factory.CommandFactory;

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
        try {
            command.processPage(request, response);
        } catch (InvalidLabelException ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

}


