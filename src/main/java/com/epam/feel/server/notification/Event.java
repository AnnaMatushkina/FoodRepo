package com.epam.feel.server.notification;

/**
 * Class of notification event.
 * 
 * @author Sergey_Klyosov
 */
public abstract class Event {
    private EventType eventType;
    private String owner;
    private String reason;

    public Event(EventType eventType, String owner, String reason) {
        this.eventType = eventType;
        this.owner = owner;
        this.reason = reason;
    }

    public EventType getEventType() {
        return eventType;
    }

    protected void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
