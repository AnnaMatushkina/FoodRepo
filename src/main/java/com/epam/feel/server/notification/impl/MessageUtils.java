package com.epam.feel.server.notification.impl;

import static com.epam.feel.server.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.server.IEpamFeelMessages.MESSAGES;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.epam.feel.server.mail.MailMessage;
import com.epam.feel.server.notification.EventType;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.RequestDTO;

/**
 * Message utility.
 * 
 * @author Sergey_Klyosov, Michael_Silvanovich
 */
public class MessageUtils {

    public static final String EMAIL_DELIMETER = " ";

    private static MessageUtils messageUtils;

    private final SimpleDateFormat SHORT_DATE_FORMATTER = new SimpleDateFormat("dd.MM.yyyy");

    public static MessageUtils getInstance() {
        if (messageUtils == null) {
            messageUtils = new MessageUtils();
        }
        return messageUtils;
    }

    /**
     * Getting email message from event
     * 
     * @param event
     * @return email message
     */
    public MailMessage getMessage(EventRequestDTO event) {
        if ((event == null) || (event.getObject() == null)) {
            return null;
        }
        MailMessage emailMessage = null;

        RequestDTO order = event.getObject();
        if (order.getClient().isAdvised()) {
            emailMessage = new MailMessage();
            emailMessage.setSender(event.getOwner());
            emailMessage.getRecepients().add(order.getClient().getEmail());

            switch (event.getEventType()) {
                case DELETED:
                    emailMessage.setText(MESSAGES.orderDeleted(String.valueOf(order.getId()),
                        SHORT_DATE_FORMATTER.format(order.getCreateDate()), event.getReason()));
                    emailMessage.setSubject(CONSTANTS.orderDeletedEmailSubject());
                    break;
                case CHANGED:
                    emailMessage.setText(MESSAGES.orderChanged(String.valueOf(order.getId()),
                        SHORT_DATE_FORMATTER.format(order.getCreateDate()), String.valueOf(order.getCost()),
                        event.getReason()));
                    emailMessage.setSubject(CONSTANTS.orderChangedEmailSubject());
                    break;
                case DECLINED:
                    emailMessage.setText(MESSAGES.orderDeclined(String.valueOf(order.getId()),
                        SHORT_DATE_FORMATTER.format(order.getCreateDate()), event.getReason()));
                    emailMessage.setSubject(CONSTANTS.orderDeclinedEmailSubject());
                    break;
                case PERFORMED:
                case DELIVERED:
                    emailMessage.setText(MESSAGES.orderDelivered(String.valueOf(order.getId()),
                        SHORT_DATE_FORMATTER.format(order.getCreateDate())));
                    emailMessage.setSubject(CONSTANTS.orderDeliveredEmailSubject());
                    break;
            }
        }
        return emailMessage;
    }

    /**
     * Getting email message from event
     * 
     * @param event
     * @return email message
     */
    public MailMessage getMessage(EventGroupRequestDTO event) {
        if ((event == null) || (event.getObject() == null)) {
            return null;
        }
        MailMessage emailMessage = null;

        if (event.getEventType() == EventType.DELETED) {
            GroupRequestDTO orderGroup = event.getObject();
            for (RequestDTO order : orderGroup.getRequests()) {
                if (order.getClient().isAdvised()) {
                    if (emailMessage == null) {
                        emailMessage = new MailMessage();
                    }
                    emailMessage.getRecepients().add(order.getClient().getEmail());
                }
            }

            if (emailMessage != null) {
                emailMessage.setSubject(CONSTANTS.orderGroupDeletedEmailSubject());
                emailMessage.setText(MESSAGES.orderGroupDeleted(
                    SHORT_DATE_FORMATTER.format(orderGroup.getCreateDate()), event.getReason()));
                emailMessage.setSender(event.getOwner());
            }
        }
        return emailMessage;
    }

    /**
     * Getting NotificationDTO object from email message
     * 
     * @param mailMessage
     * @return NotificationDTO object
     */
    public NotificationDTO mailMessageToNotificationDTO(MailMessage mailMessage) {
        StringBuilder sb = new StringBuilder();
        for (String email : mailMessage.getRecepients()) {
            if (sb.length() > 0) {
                sb.append(EMAIL_DELIMETER);
            }
            sb.append(email);
        }
        NotificationDTO notificaction = new NotificationDTO(null, new Date(), mailMessage.getSender(), sb.toString(),
            mailMessage.getText());
        return notificaction;
    }

}
