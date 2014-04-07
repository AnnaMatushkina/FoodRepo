package com.epam.feel.server.servlet;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;
import gwtupload.shared.UConsts;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.server.service.MenuInfoServiceImpl;
import com.epam.feel.server.util.ImageUtil;
import com.epam.feel.shared.WebAppConstants;

/**
 * Service for upload image.
 * 
 * @author Artem_Tumasov
 */
public class FileUpload extends UploadAction {

    private static final long serialVersionUID = 8047672836989555469L;
    private static final long MAX_FILE_SIZE = 10 * 1024;
    private static final Hashtable<String, String> receivedContentTypes = new Hashtable<String, String>();
    private final static Logger LOG = LoggerFactory.getLogger(MenuInfoServiceImpl.class);
    /**
     * Maintain a list with received files and their content types.
     */
    private static final Hashtable<String, File> receivedFiles = new Hashtable<String, File>();

    /**
     * Override executeAction to save the received files in a custom place and delete this items from session.
     */
    @Override
    public String executeAction(HttpServletRequest request, List<FileItem> sessionFiles) throws UploadActionException {
        StringBuilder response = new StringBuilder();
        for (FileItem item : sessionFiles) {
            if (!item.isFormField()) {
                try {
                    // Create a temporary file placed in the default system temp folder
                    File file = File.createTempFile("upload-", ".bin");
                    item.write(file);
                    long fileSize = file.length();

                    if (fileSize < MAX_FILE_SIZE) {
                        // Save a list with the received files
                        receivedFiles.put(item.getFieldName(), file);
                        receivedContentTypes.put(item.getFieldName(), item.getContentType());
                        // Send a customized message to the client.
                        response.append("File saved as " + file.getAbsolutePath());
                    } else {
                        response.append(WebAppConstants.UPLOAD_MESSAGE_LONG_FILE);
                    }

                } catch (Exception e) {
                    throw new UploadActionException(e);
                }
            }
        }

        // Remove files from session because we have a copy of them
        removeSessionFileItems(request);

        // Send your customized message to the client.
        return response.toString();
    }

    /**
     * Get the content of an uploaded file.
     */
    @Override
    public void getUploadedFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fieldName = request.getParameter(UConsts.PARAM_SHOW);
        File f = receivedFiles.get(fieldName);
        if (f != null) {
            response.setContentType(receivedContentTypes.get(fieldName));
            FileInputStream is = new FileInputStream(f);
            copyFromInputStreamToOutputStream(is, response.getOutputStream());
        } else {
            renderXmlResponse(request, response, XML_ERROR_ITEM_NOT_FOUND);
        }
    }

    /**
     * Remove a file when the user sends a delete request.
     */
    @Override
    public void removeItem(HttpServletRequest request, String fieldName) throws UploadActionException {
        File file = receivedFiles.get(fieldName);
        receivedFiles.remove(fieldName);
        receivedContentTypes.remove(fieldName);
        if (file != null) {
            file.delete();
        }
    }

    public static byte[] getImageBytes(String fieldName) {
        byte[] result = null;
        try {
            result = ImageUtil.fileToByte(receivedFiles.get(fieldName));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

}