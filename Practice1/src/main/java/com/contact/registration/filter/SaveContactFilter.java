package com.contact.registration.filter;

import com.contact.registration.service.ContactService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: iason
 * Date: 24.03.14
 */
public class SaveContactFilter implements Filter {
    Filter filter;

    public SaveContactFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ContactService.putContact(request);
        if (filter != null) {
            filter.execute(request, response);
        }
    }
}
