package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;
import com.example.demo.domain.service.IEventService;
import com.example.demo.domain.service.IUserService;
import com.example.demo.repositories.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {

    @Autowired
    IEventService eventService;

    @Autowired
    IUserService userService;

    @Autowired
    EventRepository eventRepositoryMock = Mockito.mock(EventRepository.class);

    @BeforeEach
    void setUp() {
        System.out.println("Iniciando test");
    }
/*
    @Test
    void eventList() {

        List<Event> mockEvents = List.of(
                new Event("Barcelona",
                        "https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg",
                        "Paseos nocturnos por la ciudad"
                        );
                eventRepositoryMock.findAll(mockEvents);
        mockEvents.setId((long)1);
        mockEvents.setTitle("Barcelona");
        mockEvents.setImage("{"+"\"coverImage\":\"https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg\"}");
        mockEvents.setDescription("Paseos nocturnos por la ciudad" );
        mockEvents.setDate("10/07/2022");

        Mockito.when(eventRepositoryMock.findAll()).thenReturn(mockEvents);
    }*/
/*
    @Test
    void formCreate() {
    }
*/
    @Test
    void saveEvent() {
        List<Event> mockEvents = List.of(
                new Event("Barcelona",
                        "https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg",
                        "Paseos nocturnos por la ciudad.")
        );
        eventRepositoryMock.saveAll(mockEvents);
    }


    @AfterEach
    void tearDown() {
        System.out.println("Test finalizado");
    }
}