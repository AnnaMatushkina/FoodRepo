package com.epam.feel.server.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.epam.auth.filter.AmFilter;

/**
 * Filter for check user and process authorization user on server.
 * 
 * @author Michael_Silvanovich
 */
public class AuthorizationFilter extends AmFilter {

    private static final String SERVICE_TOKEN = "springGwtServices";

    @Override
    protected void sendRedirectToAM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getServletPath().contains(SERVICE_TOKEN)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            super.sendRedirectToAM(request, response);
        }
    }
}
