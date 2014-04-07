package com.epam.feel.server.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.epam.feel.server.mail.MailMessage;
import com.epam.feel.server.notification.impl.EventGroupRequestDTO;
import com.epam.feel.server.notification.impl.EventQueueImpl;
import com.epam.feel.server.notification.impl.EventRequestDTO;
import com.epam.feel.server.notification.impl.MessageUtils;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.RequestDTO;

/**
 * Test for notification service functions.
 * 
 * @author Sergey_Klyosov
 */
public class NotificationTest {

    public static final String DEFAULT_SENDER = "test@mail.com";

    public Event event = new EventRequestDTO(new RequestDTO(), EventType.DELETED, DEFAULT_SENDER);
    private static long TIMEOUT = 10000L;
    private Object lockObject = new Object();

    private MessageUtils messageUtils = MessageUtils.getInstance();

    public class ThreadHelper implements IEventProcessor {

        private Event event = null;

        public void process(Event event) {
            synchronized (lockObject) {
                this.event = event;
                lockObject.notify();
            };

        }

        public Event getEvent() {
            return event;
        }
    }

    /**
     * Test method for {@link com.epam.feel.server.notification.impl.EventQueueImpl}
     * 
     * @throws InterruptedException
     */
    @Test
    public void eventQueueTest() throws InterruptedException {

        ThreadHelper helper = new ThreadHelper();
        EventQueueImpl queue = new EventQueueImpl();
        queue.setProcessor(helper);
        synchronized (lockObject) {
            queue.push(event);
            lockObject.wait(TIMEOUT);
        }

        assertEquals(event, helper.getEvent());

    }

    @Test
    public void MessageUtilsTest() {

        RequestDTO request = RequestHelper.getRequestDTO();

        MailMessage msg;
        EventRequestDTO event;

        event = new EventRequestDTO(request, EventType.CHANGED, DEFAULT_SENDER);
        msg = messageUtils.getMessage(event);
        assertNotNull(msg);

        String text = msg.getText();
        msg = messageUtils.getMessage(event);
        assertEquals(text, msg.getText());

        event = new EventRequestDTO(request, EventType.DELETED, DEFAULT_SENDER);
        msg = messageUtils.getMessage(event);
        assertNotNull(msg);

        event = new EventRequestDTO(request, EventType.PERFORMED, DEFAULT_SENDER);
        msg = messageUtils.getMessage(event);
        assertNotNull(msg);

        event = new EventRequestDTO(request, EventType.DECLINED, DEFAULT_SENDER);
        msg = messageUtils.getMessage(event);
        assertNotNull(msg);
        assertFalse(msg.getRecepients().isEmpty());

        ClientDTO client = request.getClient();
        client.setAdvised(false);
        request.setClient(client);
        event = new EventRequestDTO(request, EventType.DECLINED, DEFAULT_SENDER);
        msg = messageUtils.getMessage(event);

        assertTrue(msg == null);

        client.setAdvised(true);

        GroupRequestDTO groupRequestDTO = RequestHelper.getGroupRequestDTO(request);

        msg = messageUtils.getMessage(new EventGroupRequestDTO(groupRequestDTO, EventType.DELETED, "", DEFAULT_SENDER));
        assertNotNull(msg);

    }
}
