package com.epam.feel.server.notification.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.IEventProcessor;
import com.epam.feel.server.notification.IEventQueue;

/**
 * Notification event queue.
 * 
 * @author Sergey_Klyosov
 */
public final class EventQueueImpl implements IEventQueue {

    private final static Logger LOG = LoggerFactory.getLogger(EventQueueImpl.class);

    private static int WAIT_TIMEOUT = 10000;

    private AtomicBoolean isStopping = new AtomicBoolean(false);
    private Queue<Event> queue = new ConcurrentLinkedQueue<Event>();
    private Thread thread = null;

    @Autowired
    private IEventProcessor processor;

    @Override
    protected void finalize() throws Throwable {
        isStopping.set(true);
        thread.join();
    }

    /**
     * Push notification event
     */
    public void push(Event event) {
        if ((thread == null) || (thread.getState() == Thread.State.TERMINATED)) {
            thread = new Thread() {

                @Override
                public void run() {
                    Event event = null;
                    try {
                        while (true) {
                            if (isStopping.get()) {
                                break;
                            }
                            if (queue.isEmpty()) {
                                event = null;
                            } else {
                                event = queue.poll();
                            }
                            if (event == null) {
                                synchronized (this) {
                                    wait(WAIT_TIMEOUT);
                                }
                            } else {
                                processor.process(event);
                            }
                        }
                    } catch (InterruptedException e) {
                        LOG.error(e.getMessage());
                    }
                }
            };
            thread.start();
        }

        queue.offer(event);

        synchronized (this) {
            if (thread.getState() == Thread.State.WAITING) {
                this.notify();
            }
        }
    }

    public void setProcessor(IEventProcessor processor) {
        this.processor = processor;
    }

}
