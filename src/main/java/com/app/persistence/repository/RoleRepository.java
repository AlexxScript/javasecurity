package com.app.persistence.repository;

import javax.management.relation.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.persistence.entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity,Long>{

}
