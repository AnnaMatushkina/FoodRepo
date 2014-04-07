package com.epam.feel.server.notification;

/**
 * Interface of notification events queue.
 * 
 * @author Sergey_Klyosov
 */
public interface IEventQueue {

    /**
     * Push event
     * 
     * @param event
     */
    void push(Event event);

}
