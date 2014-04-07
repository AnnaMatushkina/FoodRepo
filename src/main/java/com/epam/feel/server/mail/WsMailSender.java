package com.epam.feel.server.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.server.mail.ws.DictionaryCode;
import com.epam.feel.server.mail.ws.MailerWS;
import com.epam.feel.server.mail.ws.MailerWSBeanService;
import com.epam.feel.server.mail.ws.Message;
import com.epam.feel.server.mail.ws.SimpleResponse;
import com.epam.feel.server.util.ConfigUtils;

/**
 * Class for sending email by web service.
 * 
 * @author Sergey_Klyosov
 */
public class WsMailSender implements IMailSender {

    private final static Logger LOG = LoggerFactory.getLogger(WsMailSender.class);

    private MailerWS mailer = new MailerWSBeanService().getMailerWSBeanPort();

    /**
     * - sender for including into email message
     */

    public WsMailSender() {

    }

    /**
     * @param msg
     *            - email message
     */
    @Override
    public boolean sendMessage(MailMessage msg) {

        if (!ConfigUtils.isEmailingEnabled() || !MailMessage.isValid(msg))
            return false;

        final Message message = new Message();

        message.setAnonimous(false);
        message.setSender(msg.getSender());
        message.setSubject(msg.getSubject());
        message.setText(msg.getText());
        message.getDeliveryTypes().add(DictionaryCode.EMAIL);
        for (String email : msg.getRecepients()) {
            message.getMessageRecepients().add(email);
        }

        SimpleResponse response = mailer.sendNewMessageWithRecepients(message, false);

        if (response.getErrcode() != 0) {
            LOG.error("Error " + response.getErrcode() + " sending email." + response.getDescription());
        } else {
            LOG.debug(response.getDescription());
        }

        return response.getErrcode() == 0;
    }

}
