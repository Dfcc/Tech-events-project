package com.example.demo.controllers;
import com.example.demo.domain.entities.Event;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.service.IEventService;
import com.example.demo.domain.service.IUserService;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.Optional;

@Controller

@RequestMapping("/users")

public class UserController {


    @Autowired
    private IEventService eventService;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;



    @GetMapping("/home")
    public String allUsers(Model model,@PathVariable(value = "eventId") Long eventId){
        List <User> eventsUserList = userRepository.findUsersByEventsId(eventId);
        List <User> usersList = userService.usersList();
        model.addAttribute("titulo", "Pagina Home de Usuario");
        model.addAttribute("users", usersList);
        model.addAttribute("userEvents", eventsUserList);
        return "/views/users/usersList";
    }
    @GetMapping("/userEventAdd/{id}")
    public String userEventAdd(Authentication auth, @PathVariable("id") Long idEvent){
        Event event = eventService.findById(idEvent);

        String username = auth.getName();
         User user = userService.findByUsername(username);

//        if (user.contains(event)){
//            System.out.println("Evento duplicado!");
//        }
//        else{
            event.setSigned(event.getSigned()+1);
            eventRepository.save(event);
            System.out.println("apuntado al evento " + event.getSigned());
            user.getEvents().add(event);
            userRepository.save(user);
//        }

        return "redirect:/users/home";
    }
    @GetMapping("/create")
    public String formCreate(Model model) {
        User user = new User();
        model.addAttribute("titulo", "Nuevo usuario");
        model.addAttribute("user", user);

        return "/views/users/userCreate";
    }
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model model, RedirectAttributes attribute) {
        if(result.hasErrors()){
            model.addAttribute("titulo", "Nuevo usuario");
            model.addAttribute("user",user);
            System.out.println("Existen fallos en el formulario");
            return "/views/users/userCreate";
        }

        userService.saveUser(user);
        attribute.addFlashAttribute("success", "usuario registrado con exito");
        return "redirect:/index";

    }

}
    // Event event = new Event();
    // event.getNombre()
    // event.getUsers()
    // Le pasamos un nuevo usuario
    // Actualizar este dato con el repository
    // eventRepository.save(event)
    // many to many save spring boot


