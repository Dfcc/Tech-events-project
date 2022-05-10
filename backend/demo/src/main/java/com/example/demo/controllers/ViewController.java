package com.example.demo.controllers;

import com.example.demo.domain.entities.Event;
import com.example.demo.domain.service.IEventService;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class ViewController {
    @Autowired
    private IEventService eventService;
    @Autowired
    private EventRepository eventRepository;
    @GetMapping({"/","/home", "/index"})
    public String eventSlider(HttpServletRequest request, Model model){
        List<Event> eventSlider = eventService.listHighlights();
        List<Event> eventList = eventService.eventList();
        int page = 0; //default page number is 0 (yes it is weird)
        int size = 3; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        model.addAttribute("events", eventRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"date"))));

        List<Event> listHighlights = eventService.listHighlights();
        model.addAttribute("destacados", listHighlights);

        model.addAttribute("titulo", "Events List No order");
        model.addAttribute("slider", eventSlider);
        model.addAttribute("titulo", "List No order");
        model.addAttribute("list", eventList);


        return "index";
    }
}


