package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;

import com.example.demo.domain.service.IEventService;
import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/views/events")

public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/")
    public String eventList(Model model){

        List<Event> eventList = eventService.eventList();
        model.addAttribute("titulo", "Events List No order");
        model.addAttribute("eventos", eventList);

      return "/views/events/eventList";
    }
    @GetMapping("/admin/create")
    public String formCreate(Model model){

      return "/views/events/formCreate";
    }

}
