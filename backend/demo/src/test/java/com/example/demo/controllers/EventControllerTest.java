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

        Event mockEvent = new Event();
        mockEvent.setId((long)1);
        mockEvent.setTitle("titulo");
        mockEvent.setImage("{"+"\"coverImage\":\"https://www.xmigrations.com/wp-content/uploads/2020/06/Free-Tour-Barcelona-Nocturna1IMG.-Jorge-Franganillo.jpg\"}");
        mockEvent.setDescription("Paseos nocturnos por la ciudad" );
        mockEvent.setDate("10/07/2022");
    }

    @Test
    void formCreate() {
    }

    @Test
    void saveEvent() {
    }

    @Test
    void testEventList() {
    }

    @Test
    void testFormCreate() {
    }

    @Test
    void testSaveEvent() {
    }
    @AfterEach
    void tearDown() {
        System.out.println("Test finalizado");
    }
}