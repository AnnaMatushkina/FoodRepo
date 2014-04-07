package com.epam.feel.server.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.model.Image;
import com.epam.feel.shared.service.ServiceUtils;

/**
 * Servlet returning image content from DB by given identifier in GET-method parameters.
 * 
 * @author Michael_Silvanovich
 */
public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 4068948649530908885L;

    private static final Logger LOG = LoggerFactory.getLogger(ImageServlet.class);
    private static final String HTTP_HEADER_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private final SimpleDateFormat HTTP_HEADER_DATE_FORMATTER = new SimpleDateFormat(HTTP_HEADER_DATE_FORMAT);

    private static final String HEADER_LAST_MODIFIED = "Last-Modified";
    private static final String HEADER_IF_MODIFIED_SINCE = "If-Modified-Since";
    private static final String HEADER_EXPIRES = "Expires";
    private static final String HEADER_CACHE_CONTROL = "Cache-Control";

    private static final String IMAGE_CONTENT_TYPE = "image/png";
    private static final int EXPIRE_DATE_DAYS = 7;
    private static final String VALUE_CACHE_CONTROL = "public, max-age=" + (EXPIRE_DATE_DAYS * 24 * 60 * 60)
        + ", must-revalidate";

    private static final long MILLISECONDS_IN_SECOND = 1000;

    private MenuDao menuDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        injectDependencies(WebApplicationContextUtils.getWebApplicationContext(getServletContext()));
    }

    /**
     * Used to inject dependencies from spring web application context
     * 
     * @param context
     *            spring web application context
     */
    protected void injectDependencies(WebApplicationContext context) {
        menuDao = context.getBean(MenuDao.class);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idParamString = req.getParameter(ServiceUtils.PARAMETER_IMAGE_ID);
        try {
            final Long id = Long.parseLong(idParamString);
            Image image = menuDao.getImage(id);
            if (image == null) {
                LOG.debug("image with id " + id + " is not found");
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            } else {

                LOG.debug("image is found");

                final String modifiedSince = req.getHeader(HEADER_IF_MODIFIED_SINCE);
                if (!StringUtils.hasText(modifiedSince) || isModified(image, modifiedSince)) {
                    resp.setContentType(IMAGE_CONTENT_TYPE);
                    setCacheControl(resp);
                    resp.getOutputStream().write(image.getContent());
                } else {
                    LOG.debug("image is not modified");
                    resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                }

                addLastModifiedHeader(resp, image.getDate());

            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private boolean isModified(Image image, String modifiedSince) throws ParseException {
        final Date imageDate = image.getDate();
        final Date questionDate = HTTP_HEADER_DATE_FORMATTER.parse(modifiedSince);
        return ((imageDate.getTime() - questionDate.getTime()) / MILLISECONDS_IN_SECOND) > 0;
    }

    private void addLastModifiedHeader(HttpServletResponse response, Date date) {
        response.setHeader(HEADER_LAST_MODIFIED, HTTP_HEADER_DATE_FORMATTER.format(date));
    }

    private void setCacheControl(HttpServletResponse response) {
        response.setHeader(HEADER_EXPIRES,
            HTTP_HEADER_DATE_FORMATTER.format(DateUtils.addDays(new Date(), EXPIRE_DATE_DAYS)));
        response.setHeader(HEADER_CACHE_CONTROL, VALUE_CACHE_CONTROL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

}
