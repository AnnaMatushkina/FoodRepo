package com.epam.feel.server.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.google.gwt.user.server.Base64Utils;

/**
 * Utility for image.
 * 
 * @author Artem_Tumasov
 */
public class ImageUtil {

    public ImageUtil() {}

    /**
     * Convert object File to array of bytes
     * 
     * @param file
     *            {@link File}
     * @return array of bytes
     * @throws IOException
     */
    public static byte[] fileToByte(File file) throws IOException {
        InputStream in;
        int readByte;
        in = new FileInputStream(file);
        in.close();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((readByte = in.read()) != -1) {
            out.write(readByte);
        }
        out.flush();
        byte[] bytes = out.toByteArray();

        return bytes;
    }

    /**
     * Convert array of bytes to string encoded in Base64
     * 
     * @param bytes
     *            array of bytes
     * @return Base64 encoded string
     */
    public static String byteToImage(byte[] bytes) {
        String base64 = Base64Utils.toBase64(bytes);
        base64 = "data:image/png;base64," + base64;
        base64 = base64.replace("$", "+");
        base64 = base64.replace("_", "/");
        return base64;
    }

}
