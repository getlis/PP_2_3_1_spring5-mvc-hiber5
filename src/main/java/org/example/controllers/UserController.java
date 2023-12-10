package org.example.controllers;

import org.example.models.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/", "/index", })
    public String users(Model model) {

        model.addAttribute( "users", userService.getAll() );
        return "users/index";
    }

    @GetMapping({"/create"})
    public String create() {
        return "users/create";
    }

    @PostMapping({"/create"})
    public String save( @ModelAttribute("user") User user ) {
        userService.add( user );
        return "redirect:/users/index";
    }



    @GetMapping({"/delete"})
    public String delete( @RequestParam("id") int id ) {
        userService.delete( id );
        return "redirect:/users/index";
    }


    @GetMapping({"/update"})
    public String update(Model model, @RequestParam("id") int id ) {
        model.addAttribute( "user", userService.get( id ) );
        return "users/update";
    }

    @PostMapping({"/update"})
    public String update( @ModelAttribute("user") User user ) {
        System.out.println( user.getId() );
        userService.uptdate( user );
        return "redirect:/users/index";
    }

}
