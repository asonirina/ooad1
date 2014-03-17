package com.contact.registration.command;

import com.contact.registration.exception.InvalidLabelException;
import com.contact.registration.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: iason
 * Date: 17.03.14
 */
public class FinalCommand implements Command {
    @Override
    public void processPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvalidLabelException {
        ContactService.putContact(request, 3);
        request.getRequestDispatcher("final.jsp").forward(request, response);
    }
}
