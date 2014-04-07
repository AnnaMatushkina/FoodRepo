package com.epam.feel.server.notification.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.feel.server.mail.IMailSender;
import com.epam.feel.server.mail.MailMessage;
import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.IEventProcessor;
import com.epam.feel.shared.service.HistoryInfoService;

/**
 * Processor of notification events.
 * 
 * @author Sergey_Klyosov
 */
public class EventProcessorImpl implements IEventProcessor {

    private final static Logger LOG = LoggerFactory.getLogger(EventProcessorImpl.class);

    @Autowired
    private IMailSender mailer;

    @Autowired
    private HistoryInfoService historyInfoService;

    private MessageUtils emailMessageFactory = MessageUtils.getInstance();

    /**
     * Process a notification event
     */
    public void process(Event event) {

        LOG.debug("Processing event: " + event.toString());

        MailMessage mailMessage = null;

        if (event instanceof EventRequestDTO) {
            mailMessage = emailMessageFactory.getMessage((EventRequestDTO) event);
        } else if (event instanceof EventGroupRequestDTO) {
            mailMessage = emailMessageFactory.getMessage((EventGroupRequestDTO) event);
        }

        LOG.debug("MSG = " + mailMessage);
        if (mailMessage != null) {
            mailer.sendMessage(mailMessage);
            historyInfoService.saveNotification(emailMessageFactory.mailMessageToNotificationDTO(mailMessage));

        }

    }

}
