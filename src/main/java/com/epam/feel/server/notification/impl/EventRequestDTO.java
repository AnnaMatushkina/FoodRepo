package com.epam.feel.server.notification.impl;

import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.EventType;
import com.epam.feel.shared.dto.RequestDTO;

/**
 * Request event.
 * 
 * @author Sergey_Klyosov
 */
public class EventRequestDTO extends Event {

    private RequestDTO object;

    public EventRequestDTO(RequestDTO object, EventType eventType, String reason, String owner) {
        super(eventType, owner, reason);
        this.object = object;
    }

    public EventRequestDTO(RequestDTO object, EventType eventType, String owner) {
        this(object, eventType, null, owner);
    }

    /**
     * @return request
     */
    public RequestDTO getObject() {
        return object;
    }

    @Override
    public String toString() {

        return new StringBuilder("Event type ").append(getEventType().toString()).append(", odject: ")
            .append(object.toString()).toString();

    }
}
