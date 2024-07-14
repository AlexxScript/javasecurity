package com.app.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.persistence.entity.RolModel;
import com.app.persistence.entity.UsuarioModel;
import com.app.persistence.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void guardar(UsuarioModel usuarioModel) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuarioModel.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = usuarioRepository.findByNombre(nombre);
        if (usuarioModel == null) {
            System.out.println("Usuario o password incorrectos");
            throw new UsernameNotFoundException("Usuario o password incorrectos");
        }

        // return new User(usuarioModel.getNombre(),usuarioModel.getPassword(),mape)
        return new User(usuarioModel.getNombre(), usuarioModel.getPassword(),
                mapearAutoridadesRoles(usuarioModel.getRol()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(RolModel rol) {
        return Collections.singleton(new SimpleGrantedAuthority(rol.getNombre()));
    }
}
