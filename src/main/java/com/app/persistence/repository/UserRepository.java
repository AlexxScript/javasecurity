package com.app.persistence.repository;

import java.util.Optional;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    /*AMBOS METODOS HACEN LOS MISMO */
    Optional<UserEntity> findUserEntityByUserName(String userName);
    // UserEntity findUserEntityByUserNameUnique(String userName);

    // @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
    // Optional<UserEntity> findUser(String username);
}
