package com.example.demo.domain.service;

import com.example.demo.domain.entities.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {
    public List<Event> eventList();
    public void save(Event event);
    public Optional<Event> findById(Long id);
    public void delete(Long id);
}
