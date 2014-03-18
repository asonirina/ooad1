package com.contact.registration.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: iason
 * Date: 18.03.14
 */
public class LabelFilter implements Filter {
    Filter filter;

    public LabelFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String current = request.getParameter("current");
        if(StringUtils.isBlank(current)){
            request.getSession().setAttribute("current", 0);
        } else {
            Integer c = Integer.parseInt(current);
            if (c>(Integer)request.getSession().getAttribute("current")) {
                request.getSession().setAttribute("current", c);
            } else {
                throw new Exception("Invalid Label");
            }
        }
        if (filter != null) {
            filter.execute(request, response);
        }
    }
}
