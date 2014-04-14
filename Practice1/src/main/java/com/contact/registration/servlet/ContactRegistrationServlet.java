package com.contact.registration.servlet;

import com.contact.registration.command.Command;
import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.factory.CommandFactory;
import com.contact.registration.filter.Filter;
import com.contact.registration.filter.LabelFilter;
import com.contact.registration.filter.SaveContactFilter;

import java.io.*;
import javax.servlet.ServletException;
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
        Filter chain = new LabelFilter(new SaveContactFilter(null));
        Command command = CommandFactory.getInstance().getCommandByAction(action);
        try {
            chain.execute(request, response);
            command.processPage(request, response);
        } catch (Exception ex) {
            //request.getRequestDispatcher("error.jsp").forward(request, response);
            command.doError(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

}


