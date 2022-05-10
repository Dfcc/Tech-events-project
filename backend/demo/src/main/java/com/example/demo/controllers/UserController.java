package com.example.demo.controllers;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/views/users")

public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String allUsers(Model model){
        List <User> usersList = userService.usersList();
        model.addAttribute("titulo", "lista de usuarios");
        model.addAttribute("users", usersList);
        return "/views/users/usersList";
    }


}
