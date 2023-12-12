package org.example.controllers;


import javax.validation.Valid;
import org.example.models.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index", })
    public String users(Model model) {

        model.addAttribute( "users", userService.getAll() );
        return "users/index";
    }

//    @GetMapping({"/create"})
//    public String create(Model model) {
//        model.addAttribute("user", new User());
//        return "users/create";
//    }

    @GetMapping({"/create"})
    public String create( @ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping({"/create"})
    public String save(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if ( bindingResult.hasErrors() ) {
            return "users/create";
        }

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
    public String update( @Valid  @ModelAttribute("user") User user , BindingResult bindingResult) {

        if ( bindingResult.hasErrors() ) {
            return "users/update";
        }

        userService.uptdate( user );
        return "redirect:/users/index";
    }

}
