package com.example.demo.model.kafka;

// use mongodb
public interface EventSourcing {
    public Long eventId = null;
    public String eventType = null;// CUD
    public String entityType = null;
    public Object entityId = null;
    public Object entityData = null;
}
