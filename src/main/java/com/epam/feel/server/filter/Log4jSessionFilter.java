package com.epam.feel.server.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;
import com.epam.auth.service.client.User;
import com.google.common.base.Strings;

/**
 * Puts attributes of the session and user to the Log4J MDC.
 * 
 * @author Anna_Gavrilina
 */
public class Log4jSessionFilter extends OncePerRequestFilter {

    private static final String SESSION_ID_PARAM = "sessionId";
    private static final String USERNAME_PARAM = "username";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        boolean wasUserAdded = false;
        boolean wasSessionAdded = false;

        HttpSession session = request.getSession(false);
        if (session != null) {
            if (!Strings.isNullOrEmpty(session.getId())) {
                // May be shown using %X{sessionId} in the layout pattern.
                MDC.put(SESSION_ID_PARAM, session.getId());
                wasSessionAdded = true;
            }

            User user = (User) session.getAttribute(AuthorizationFilter.USER_PARAM_NAME);
            if (user != null && !Strings.isNullOrEmpty(user.getName())) {
                // Put the user's name into the message diagnostic context.
                // May be shown using %X{username} in the layout pattern.
                MDC.put(USERNAME_PARAM, user.getName());
                wasUserAdded = true;
            }
        }

        try {
            // Continue processing the rest of the filter chain.
            // Remove the added elements again - only if added.
            chain.doFilter(request, response);
        } finally {
            if (wasUserAdded) {
                MDC.remove(USERNAME_PARAM);
            }
            if (wasSessionAdded) {
                MDC.remove(SESSION_ID_PARAM);
            }
        }
    }

}
