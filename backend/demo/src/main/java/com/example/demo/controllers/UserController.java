package com.example.demo.controllers;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.service.IEventService;
import com.example.demo.domain.service.IUserService;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller

@RequestMapping("/users")

public class UserController {

    @Autowired
    private IUserService usersService;

    @Autowired
    private IEventService eventsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;



    @GetMapping("/")
    public String allUsers(Model model){
        List <User> usersList = userService.usersList();
        model.addAttribute("titulo", "lista de usuarios");
        model.addAttribute("users", usersList);
        return "/views/users/usersList";
    }
    @GetMapping("/events")
    public String allEventsUser(Model model,@PathVariable(value = "eventId") Long eventId){
        List <User> eventsUserList = userRepository.findUsersByEventsId(eventId);
        model.addAttribute("titulo", "lista de Eventos del usuario");
        model.addAttribute("userEvents", eventsUserList);
        return "/views/events/modal_test";
    }



}
