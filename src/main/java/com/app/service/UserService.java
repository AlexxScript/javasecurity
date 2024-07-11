package com.app.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.RoleRepository;
import com.app.persistence.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    // public UserEntity findByUserEntityName(String userName) {
    //     return this.userRepository.findUserEntityByUserNameUnique(userName);
    // }

    public UserEntity createUser(UserEntity userEntity) {
        Optional<RoleEntity> optionalRole = roleRepository.findById((long)14);
        Set<RoleEntity> roles = new HashSet<>();
        optionalRole.ifPresent(roles::add);
        userEntity = UserEntity.builder()
                .userName(userEntity.getUserName())
                .password(new BCryptPasswordEncoder().encode(userEntity.getPassword()))
                .isEnabled(true)
                .accountNoExpired(true)
                .accountNoLocked(true)
                .credentialsNoExpired(true)
                .roles(roles)
                .build();
        return this.userRepository.save(userEntity);
    }
}
