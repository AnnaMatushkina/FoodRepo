package com.epam.feel.server.mail;

import static org.mockito.Mockito.doNothing;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.EventType;
import com.epam.feel.server.notification.IEventProcessor;
import com.epam.feel.server.notification.IEventQueue;
import com.epam.feel.server.notification.RequestHelper;
import com.epam.feel.server.notification.impl.EventRequestDTO;
import com.epam.feel.server.util.ConfigUtils;

/**
 * Test of the mail service functions.
 * 
 * @author Sergey_Klyosov
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class MailSenderTest {

    public static final String DEFAULT_SENDER = "epam-feel.test@epam.com";
    private static final long EVENT_QUEUE_TEST_DELAY = 10000L;

    @Autowired
    private IMailSender mailSender;

    @Mock
    private IEventQueue eventQueue;

    @Mock
    private IEventProcessor eventProcessor;

    private MailMessage msg = new MailMessage();
    {
        msg.setSubject("Test email sending");
        msg.setText("this is a test body");
        msg.getRecepients().add("null@null.com");
        msg.setSender("com.epam.feel.server.mail.MailSenderTest");
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        doNothing().when(eventProcessor).process(Matchers.<Event> anyObject());
    }

    /**
     * Check the email sending throw the web service
     */
    @Test
    public void MailerWSBeanServiceTest() {
        Assert.assertTrue(mailSender.sendMessage(msg));
    }

    @Test
    public void eventQueueTest() throws InterruptedException {
        eventQueue.push(new EventRequestDTO(RequestHelper.getRequestDTO(), EventType.DELETED, DEFAULT_SENDER));
        Thread.sleep(EVENT_QUEUE_TEST_DELAY);
    }

    /**
     * Check the email sending to the fake service
     */
    @Test
    public void FakeMailSenderTest() {
        IMailSender mailSender = new FakeMailSender();
        testMailSender(mailSender);
    }

    private void testMailSender(IMailSender mailSender) {
        boolean isSent = mailSender.sendMessage(msg);
        Assert.assertTrue(isSent || !ConfigUtils.isEmailingEnabled());
    }

}
