package com.example.demo.domain.service;

import com.example.demo.domain.entities.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    private EventRepository eventRepository;
    @Override
    public List<Event> eventList() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);

    }

    @Override
    public Event findById(Long id) {

        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event delete(Long id) {
        eventRepository.deleteById(id);
        return null;
    }
}
