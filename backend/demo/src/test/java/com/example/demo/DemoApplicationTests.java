package com.example.demo;

import com.example.demo.domain.service.IEventService;
import com.example.demo.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class DemoApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    IEventService eventService;
    }


   /* @BeforeEach
    void setUp() {
        eventService.deleteAll();
    }
 //////////el deleteALL() no esta importado parece
    @Test
    void contextLoads() {
    }*/

    //@Test
    //void allowsToEventList() throws Exception{
        //Controller
        //given
        //when I send a post request to /events
        //mockMvc.perform(post("/list"));



        //then I get 200 status code
    //}

