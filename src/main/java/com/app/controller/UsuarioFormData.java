package com.app.controller;

import com.app.persistence.entity.UsuarioModel;

import jakarta.validation.constraints.NotBlank;

public class UsuarioFormData {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método para convertir UsuarioFormData a UsuarioModel
    public UsuarioModel toModel() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre(this.nombre);
        usuario.setPassword(this.password);
        return usuario;
    }

}
