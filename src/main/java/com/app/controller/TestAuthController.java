package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.persistence.entity.UserEntity;
// import com.app.service.UserService;
import com.app.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/auth")
// @PreAuthorize("denyAll()")
public class TestAuthController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    // @PreAuthorize("hasRole('ROLE_DEVELOPER')")
    public String helloGet(){
        return "Hello World - GET";
    }

    // @PostMapping("/post")
    // public String helloPost(){
    //     return "Hello World - POST";
    // }

    // @PutMapping("/put")
    // public String helloPut(){
    //     return "Hello World - PUT";
    // }

    // @DeleteMapping("/delete")
    // public String helloDelete(){
    //     return "Hello World - DELETE";
    // }

    // @PatchMapping("/patch")
    // public String helloPatch(){
    //     return "Hello World - PATCH";
    // }
    
    @GetMapping(path = "/adduser")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @GetMapping("/login")
    public String showFormLogin() {
        return "login";
    }
    

    @PostMapping(path = "/register")
    public String registerUser(@ModelAttribute UserEntity userEntity) {
        // if (this.userService.findByUserEntityName(userEntity.getUserName()) != null) {
        //     return "usuario existe";
        // }
        userService.createUser(userEntity);
        return "redirect:/login";
    }
    
    // @GetMapping("/hello")
    // @PreAuthorize("permitAll()")
    // public String hello() {
    //     return "hello world";   
    // }

    // @GetMapping("/hello-secured")
    // @PreAuthorize("hasAuthority('READ')")
    // public String helloSecured() {
    //     return "Hello secured";
    // }

    // @GetMapping("/hello-secure2")
    // @PreAuthorize("hasAuthority('CREATE')")
    // public String helloSecured2() {
    //     return "Hello secured2";
    // }
}
