package com.epam.feel.server.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.server.util.ConfigUtils;

/**
 * Fake class for emulating email sending.
 * 
 * @author Sergey_Klyosov
 */
public class FakeMailSender implements IMailSender {

    private final static Logger LOG = LoggerFactory.getLogger(WsMailSender.class);

    /**
     * Sending email
     * 
     * @param msg
     *            - email message
     */
    @Override
    public boolean sendMessage(MailMessage msg) {
        if (!MailMessage.isValid(msg))
            return false;
        LOG.info("Email sending -" + msg.toString());
        return ConfigUtils.isEmailingEnabled();
    }
}
