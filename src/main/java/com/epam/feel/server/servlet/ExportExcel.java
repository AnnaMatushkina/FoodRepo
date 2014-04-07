package com.epam.feel.server.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.excel.Cell;
import com.epam.feel.shared.excel.HandlerWorkBook;

/**
 * HttpServlet for download excel file.
 * 
 * @author Anna_Gavrilina
 */
public class ExportExcel extends HttpServlet {
    private final static Logger LOG = LoggerFactory.getLogger(ExportExcel.class);

    private static final long serialVersionUID = 6707612408855356827L;
    private static final String FILE_NAME = "export.xls";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        export(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        export(request, response);
    }

    @SuppressWarnings ("unchecked")
    private void export(HttpServletRequest request, HttpServletResponse response) {
        ClientDTO client = (ClientDTO) request.getSession().getAttribute(WebAppConstants.CLIENT_SESSION_KEY);
        if (client != null) {
            String attrCellName = WebAppConstants.EXPORT_EXCEL_SESSION_PARAM + client.getEmail();
            try {
                List<Cell> cells = (List<Cell>) request.getSession().getAttribute(attrCellName);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
                HandlerWorkBook.generateExcelBook(response.getOutputStream(), cells);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            } finally {
                request.getSession().removeAttribute(attrCellName);
            }
        } else {
            LOG.error("Client from session is null.");
        }
    }

}
