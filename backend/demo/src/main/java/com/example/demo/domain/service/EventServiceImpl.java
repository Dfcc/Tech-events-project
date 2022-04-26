package com.example.demo.domain.service;

import com.example.demo.domain.entities.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Event> findById(Long id) {
      return Optional.ofNullable(eventRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);

    }
}
