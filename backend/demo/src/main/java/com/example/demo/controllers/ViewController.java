package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;
import com.example.demo.domain.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class ViewController {
    @Autowired
    private IEventService eventService;

    @GetMapping({"/","/home", "/index"})
    public String eventHome(Model model){
        List<Event> eventSlider = eventService.eventList();
        List<Event> eventList = eventService.eventList();
        model.addAttribute("titulo", "Events List No order");
        model.addAttribute("slider", eventSlider);
        model.addAttribute("titulo", "List No order");
        model.addAttribute("list", eventList);
        return "index";
    }
    @GetMapping({"/home/{id}"})
    public String eventDetail(Model model, @PathVariable("id") Long idEvent){
        // Buscar el evento
        Event event = eventService.findById(idEvent);
        //Statement if event is full

             model.addAttribute("titulo", "Event Detail");
             model.addAttribute("eventDetail", event);


         return "/views/events/eventDetail";
    }
}
