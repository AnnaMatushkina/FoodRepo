package com.epam.feel.server.notification.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.IEventProcessor;
import com.epam.feel.server.notification.IEventQueue;

/**
 * Notification event queue.
 * 
 * @author Anna_Gavrilina
 */

public class EventQueueThreadPoolImpl implements IEventQueue {

    private final static Logger LOG = LoggerFactory.getLogger(EventQueueThreadPoolImpl.class);

    private static final int THREAD_POOL_SIZE = 5;
    private Queue<Event> queue = new ConcurrentLinkedQueue<Event>();
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    @Autowired
    private IEventProcessor processor;

    private Runnable task = new Runnable() {
        public void run() {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    Event event = queue.poll();
                    if (event != null) {
                        LOG.debug("Processing event " + event.toString());
                        processor.process(event);
                    }
                }
            }
        }
    };

    public void push(Event event) {
        queue.offer(event);
        executor.execute(task);
    }

    public void setProcessor(IEventProcessor processor) {
        this.processor = processor;
    }

}
