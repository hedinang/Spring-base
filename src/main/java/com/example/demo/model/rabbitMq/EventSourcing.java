package com.example.demo.model.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventSourcing<T> {
    public int eventType;// CUD
    public T data;
}