package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;

import com.example.demo.domain.service.IEventService;
import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/views/events")
public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/list")
    public String eventList(Model model){

        List<Event> eventList = eventService.eventList();
        model.addAttribute("titulo", "Events List No order");
        model.addAttribute("eventos", eventList);

      return "/views/events/eventList";
    }
    @GetMapping("/admin/create")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String formCreate(Model model){
        Event event = new Event();
        model.addAttribute("titulo","Nuevo evento ");
        model.addAttribute("event",event);

      return "/views/events/formCreate";
    }

    @PostMapping("/save")


    public String saveEvent(@ModelAttribute Event event){
        Date date;
        eventService.save(event);
        System.out.println("event saved with success");
        return "redirect:/views/events/list";

    }

}
