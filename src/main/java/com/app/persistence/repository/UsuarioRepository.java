package com.app.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.persistence.entity.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    public UsuarioModel findByNombre(String nombre);
}
