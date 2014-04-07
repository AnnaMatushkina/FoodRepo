package com.epam.feel.server.notification.impl;

import com.epam.feel.server.notification.Event;
import com.epam.feel.server.notification.EventType;
import com.epam.feel.shared.dto.GroupRequestDTO;

/**
 * Event of request group.
 * 
 * @author Sergey_Klyosov
 */
public class EventGroupRequestDTO extends Event {

    private GroupRequestDTO object;

    public EventGroupRequestDTO(GroupRequestDTO object, EventType eventType, String reason, String owner) {
        super(eventType, owner, reason);
        this.object = object;
    }

    /**
     * @return request group
     */
    public GroupRequestDTO getObject() {
        return object;
    }

    @Override
    public String toString() {
        return new StringBuilder("Event type ").append(getEventType().toString()).append(", odject: ")
            .append(object.toString()).toString();

    }

}
