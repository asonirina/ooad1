package com.contact.registration.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: iason
 * Date: 18.03.14
 */
public interface Filter {
    public void execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
