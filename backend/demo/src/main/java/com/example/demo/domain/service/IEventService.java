package com.example.demo.domain.service;

import com.example.demo.domain.entities.Event;
import com.example.demo.domain.entities.User;

import java.util.List;

public interface IEventService {
    List<Event> eventList();

   List<Event> eventListUser(Long loggedInUser);


    void save(Event event);
    Event findById(Long id);
    Event delete(Long id);

    boolean existsById(Long eventId);

    void addUser(Event event, User user);

    void removeUser(Event event, User user);
}
