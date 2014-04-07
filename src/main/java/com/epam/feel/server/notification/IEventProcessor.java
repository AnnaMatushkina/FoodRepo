package com.epam.feel.server.notification;

/**
 * Interface of event processor.
 * 
 * @author Sergey_Klyosov
 */
public interface IEventProcessor {

    /**
     * Process event
     * 
     * @param event
     */
    public void process(Event event);

}
