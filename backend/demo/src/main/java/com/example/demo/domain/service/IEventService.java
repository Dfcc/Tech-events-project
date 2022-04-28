package com.example.demo.domain.service;

import com.example.demo.domain.entities.Event;

import java.util.List;

public interface IEventService {
    public List<Event> eventList();
    public void save(Event event);
    public Event findById(Long id);
    public Event delete(Long id);
}
