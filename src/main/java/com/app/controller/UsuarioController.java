package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.persistence.entity.RolModel;
import com.app.persistence.entity.UsuarioModel;
import com.app.service.UsuarioServiceImpl;

import jakarta.validation.Valid;


@Controller
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl usuarioService;

   @GetMapping("/rutasegura")
    public String sguro() {
        return "hello";
    }

   @GetMapping("/register")
    public String formRegister(Model model) {
        model.addAttribute("formData", new UsuarioFormData());
        return "register";
    }

    @GetMapping("/login")
    public String formLogin() {
        return "login";
    } 

    @PostMapping(value = "/Usuario/Nuevo")
    public String nuevo(@Valid @ModelAttribute("formData") UsuarioFormData formData,
            BindingResult binding,
            Model model) {
        if (binding.hasErrors()) {
            // return "usuarios/nuevo";
            return "register";
        }
        try {
            UsuarioModel usuario = formData.toModel();
            usuario.setRol(new RolModel(2L,"Miembro"));
            usuarioService.guardar(usuario);
            return "redirect:/Usuarios";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            binding.rejectValue("nombre", "error.user", "Nombre de usuario ya existe");
            // return "usuarios/nuevo";
            return "register";
        }
    }
}
