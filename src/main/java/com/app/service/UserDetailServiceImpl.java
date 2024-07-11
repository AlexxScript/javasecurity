package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UserEntity userEntity = userRepository.findUserEntityByUserName(userName)
            .orElseThrow(() -> new UsernameNotFoundException("el usuario "+ userName+"no se ha encontrado"));
        
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        
        userEntity.getRoles()
            .forEach(role->authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        
        userEntity.getRoles().stream()
            .flatMap(role -> role.getPermissionList().stream())
            .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));;
        return new User(
            userEntity.getUserName(),
            userEntity.getPassword(),
            userEntity.isEnabled(),
            userEntity.isAccountNoExpired(),
            userEntity.isCredentialsNoExpired(),
            userEntity.isAccountNoLocked(),
            authorityList
        );
    }

}
