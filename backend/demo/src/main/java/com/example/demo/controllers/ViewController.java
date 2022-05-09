package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;
import com.example.demo.domain.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class ViewController {
    @Autowired
    private IEventService eventService;
    @GetMapping({"/","/home", "/index"})
    public String eventSlider(Model model){
        List<Event> eventSlider = eventService.eventList();
        List<Event> eventList = eventService.eventList();
        model.addAttribute("titulo", "Events List No order");
        model.addAttribute("slider", eventSlider);
        model.addAttribute("titulo", "List No order");
        model.addAttribute("list", eventList);

        return "index";
    }
}
