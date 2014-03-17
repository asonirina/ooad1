package com.contact.registration.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: iason
 * Date: 17.03.14
 */
public interface Command {
    public void processPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
