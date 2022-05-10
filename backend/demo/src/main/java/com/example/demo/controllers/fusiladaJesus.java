package com.example.demo.controllers;
package com.techevents.techevents.controller;

import com.techevents.techevents.entity.Events;
import com.techevents.techevents.entity.Users;
import com.techevents.techevents.repository.EventsRepository;
import com.techevents.techevents.repository.UsersRepository;
import com.techevents.techevents.service.IEventsService;
import com.techevents.techevents.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/views/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IEventsService eventsService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping("/login")
    public String login(Model model){
        Users users = new Users();
        model.addAttribute("users", users);

        return "/views/users/login";

    }

    @GetMapping("/logout")
    public String logout(){
        return "/views/users/logout";
    }

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){
        String username = auth.getName();
        if(session.getAttribute("users") == null){
            Users users = usersService.findByUsername(username);
            users.setPassword(null);
            session.setAttribute("users", users);
        }else{
            Users users = usersService.findByUsername(username);
            users.setPassword(null);
            session.setAttribute("users", users);
        }
        return "/views/users/index";
    }

    @GetMapping("/userEventAdd/{id}")
    public String userEventAdd(Authentication auth, @PathVariable("id") Long idEvent){
        Events event = eventsService.buscadorPorId(idEvent);

        String username = auth.getName();
        Users user = usersService.findByUsername(username);

        if (user.getEvents().contains(event)){
            System.out.println("Evento duplicado!");
        }
        else{
            event.setSigned(event.getSigned()+1);
            eventsRepository.save(event);
            System.out.println("apuntado al evento " + event.getSigned());
            user.getEvents().add(event);
            usersRepository.save(user);
        }

        return "redirect:/views/users/index";
    }

    @GetMapping("/userEventRemove/{id}")
    public String userEventRemove(Authentication auth, @PathVariable ("id") Long idEvent){
        Events event = eventsService.buscadorPorId(idEvent);

        String username = auth.getName();
        Users user = usersService.findByUsername(username);

        if (user.getEvents().contains(event)){
            event.setSigned(event.getSigned()-1);
            eventsRepository.save(event);
            System.out.println("Eliminado del evento");
            user.getEvents().remove(event);
            usersRepository.save(user);
        }
        else{
            System.out.println("Evento no encontrado");
        }

        return "redirect:/views/users/index";
    }

    @GetMapping("/")
    public String listarUsers(Model model){
        List<Users> listadoUsers = usersService.listarTodos();

        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("users", listadoUsers);
        return"/views/users/listar";
    }
    @GetMapping("/create")
    public String crear (Model model) {

        Users users = new Users();
        /*List<Users> listUsers= usersService.listaUsers();*/

        model.addAttribute("titulo", "Form: New User");
        model.addAttribute("users", users);
        /* model.addAttribute("users", listUsers);*/

        return "/views/users/frmUsers";
    }
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Users users, BindingResult result,
                          Model model, RedirectAttributes attribute){
        /*List<Users> listUsers = usersService.listaUsers();*/

        if (result.hasErrors()){
            model.addAttribute("titulo", "Form: New Event");
            model.addAttribute("users", users);
            /*model.addAttribute("users", listUsers);*/
            System.out.println("Hubo errores en el formulario");

            return "/views/users/frmUsers";
        }

        usersService.guardar(users);
        System.out.println("Usuario guardado con exito!");
        attribute.addFlashAttribute("sucess","Evento guardado con exito");
        return "redirect:/views/users/";
    }

    @GetMapping("/edit/{id}")
    public String editar (@PathVariable("id") Long idUsers, Model model,
                          RedirectAttributes attribute){

        Users users = null;

        if(idUsers > 0) {
            users = usersService.buscadorPorId(idUsers);

            if(users == null){
                System.out.println("Error: El Id indicado no existe!");
                attribute.addFlashAttribute("error","Atención: El Id indicado no existe!");
                return "redirect:/views/users/";
            }
        }else {
            System.out.println("Error: Hay un error con el Id!");
            attribute.addFlashAttribute("error","Atención: error con el Id!");
            return "redirect:/views/users/";
        }

        /*List<Users> listUsers = usersService.listaUsers();*/

        model.addAttribute("titulo", "Form: Edit User");
        model.addAttribute("users", users);
        /* model.addAttribute("users", listUsers);*/


        return "/views/users/frmUsers";
    }

    @GetMapping("/delete/{id}")
    public String eliminar (@PathVariable("id") Long idUsers, RedirectAttributes attribute){
        Users users = null;

        if(idUsers > 0) {
            users = usersService.buscadorPorId(idUsers);

            if(users == null){
                System.out.println("Error: El Id indicado no existe!");
                attribute.addFlashAttribute("error","Atención: El Id indicado no existe!");
                return "redirect:/views/users/";
            }
        }else {
            System.out.println("Error: Hay un error con el Id!");
            attribute.addFlashAttribute("error","Atención: error con el Id!");
            return "redirect:/views/users/";
        }

        usersService.eliminar(idUsers);
        System.out.println("Registro eliminado con éxito!");
        attribute.addFlashAttribute("warning","Registro eliminado con éxito!");

        return "redirect:/views/users/";
    }
}
