package com.epam.feel.server.mail;

import java.util.ArrayList;
import java.util.List;
import com.epam.feel.server.notification.impl.MessageUtils;

/**
 * Email message.
 * 
 * @author Sergey_Klyosov
 */
public class MailMessage {

    /**
     * Checks that message can be sent
     * 
     * @param msg
     *            - email message
     * @return - if false than the message can not be sent
     */
    public static boolean isValid(MailMessage msg) {
        return ((msg != null) && (msg.recepients != null) && !msg.recepients.isEmpty());
    }

    private String sender;
    private String subject;
    private String text;
    private List<String> recepients;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Mail message\n").append("Sender: ").append(sender).append("Subject: ")
            .append(subject).append("Body:\n").append(text).append("\n").append("Recepients: ");

        for (String item : recepients) {
            if (sb.length() > 0) {
                sb.append(MessageUtils.EMAIL_DELIMETER);
            }
            sb.append(item);
        }

        return sb.toString();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getRecepients() {
        if (recepients == null) {
            recepients = new ArrayList<String>();
        }
        return recepients;
    }

}
