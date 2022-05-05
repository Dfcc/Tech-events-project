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

    @Test
    void eventList() {

        Event mockEvent1 = new Event();
        mockEvent1.setId((long)1);
        mockEvent1.setTitle("Barcelona");
        mockEvent1.setImage("{"+"\"coverImage\":\"https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg\"}");
        mockEvent1.setDescription("Paseos nocturnos por la ciudad" );
        mockEvent1.setDate("10/07/2022");
        List<Event> mockEvents = List.of(mockEvent1);


        Mockito.when(eventRepositoryMock.findAll()).thenReturn(mockEvents);
    }

    @Test

   void formCreate() {
        List<Event> mockEvents = List.of(
                new Event("Barcelona",
                        "https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg",
                        "Paseos nocturnos por la ciudad.")
        );
        eventRepositoryMock.saveAll(mockEvents);

    }
/*
    @Test
    void saveEvent() {

    }*/


    @AfterEach
    void tearDown() {
        System.out.println("Test finalizado");
    }
}