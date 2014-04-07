package com.epam.feel.server.mail;

/**
 * Interface for sending email.
 * 
 * @author Sergey_Klyosov
 */
public interface IMailSender {

    /**
     * Send the message by email
     * 
     * @param msg
     *            - email message
     * @return - if message sent return true, otherwise return false
     */
    boolean sendMessage(MailMessage msg);

}
