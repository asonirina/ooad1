package com.contact.registration.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContactRegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(true);
        String forward = "";
        String action = request.getParameter("action");
        if (action != null && action.length() > 0) {
            session.setAttribute("action", action);

            if ("aCompany".equals(action)) {
                forward = "company.jsp";
            } else if ("aPersonalInfo".equals(action)) {
                request.setAttribute("companyname", request.getParameter("companyname"));
                forward = "personal.jsp";
            } else if ("aSave".equals(action)) {
                forward = "final.jsp";
            }

        } else {
            forward = "first_last.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}


