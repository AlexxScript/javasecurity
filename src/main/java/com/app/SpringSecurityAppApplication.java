package com.app;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.persistence.entity.PermissionEntity;
import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(UserRepository userRespository) {
	// 	return args -> {
	// 		/*Create permission */
	// 		PermissionEntity createPermission = PermissionEntity.builder()
	// 			.name("CREATE")	
	// 			.build();	
	// 		PermissionEntity readPermission = PermissionEntity.builder()

	// 			.name("READ")	
	// 			.build();

	// 		PermissionEntity updatePermission = PermissionEntity.builder()
	// 			.name("UPDATE")	
	// 			.build();		
		
	// 		PermissionEntity deletePermission = PermissionEntity.builder()
	// 			.name("DELETE")	
	// 			.build();

	// 		PermissionEntity refactorPermission = PermissionEntity.builder()
	// 			.name("REFACTOR")	
	// 			.build();

	// 		/*Create roles */
	// 		RoleEntity roleAdmin = RoleEntity.builder()
	// 			.roleEnum(RoleEnum.ADMIN)
	// 			.permissionList(Set.of(createPermission,readPermission,deletePermission,updatePermission))
	// 			.build();

	// 		RoleEntity roleUser = RoleEntity.builder()
	// 			.roleEnum(RoleEnum.USER)
	// 			.permissionList(Set.of(createPermission,readPermission))
	// 			.build();
			
	// 		RoleEntity roleInvited = RoleEntity.builder()
	// 			.roleEnum(RoleEnum.INVITED)
	// 			.permissionList(Set.of(readPermission))
	// 			.build();
			
	// 		RoleEntity roleDeveloper = RoleEntity.builder()
	// 			.roleEnum(RoleEnum.DEVELOPER)
	// 			.permissionList(Set.of(refactorPermission,createPermission,readPermission,deletePermission,updatePermission))
	// 			.build();
		
	// 		/*Create user */
	// 		UserEntity userAlejandro = UserEntity.builder()
	// 			.userName("Alejandro")
	// 			.password("$2a$10$wNXvQWhBxIulhH8swITGXuVjrz7l8r9GhCAtsYpIS0uyUlakW/74K")
	// 			.isEnabled(true)
	// 			.accountNoExpired(true)
	// 			.accountNoLocked(true)
	// 			.credentialsNoExpired(true)
	// 			.roles(Set.of(roleAdmin))
	// 			.build();

	// 		UserEntity userSantiago = UserEntity.builder()
	// 			.userName("Santiago")
	// 			.password("$2a$10$wNXvQWhBxIulhH8swITGXuVjrz7l8r9GhCAtsYpIS0uyUlakW/74K5")
	// 			.isEnabled(true)
	// 			.accountNoExpired(true)
	// 			.accountNoLocked(true)
	// 			.credentialsNoExpired(true)
	// 			.roles(Set.of(roleUser))
	// 			.build();

	// 		UserEntity userDaniel = UserEntity.builder()
	// 			.userName("Daniel")
	// 			.password("$2a$10$wNXvQWhBxIulhH8swITGXuVjrz7l8r9GhCAtsYpIS0uyUlakW/74K")
	// 			.isEnabled(true)
	// 			.accountNoExpired(true)
	// 			.accountNoLocked(true)
	// 			.credentialsNoExpired(true)
	// 			.roles(Set.of(roleInvited))
	// 			.build();

	// 		UserEntity userAnyi = UserEntity.builder()
	// 			.userName("Anyi")
	// 			.password("$2a$10$wNXvQWhBxIulhH8swITGXuVjrz7l8r9GhCAtsYpIS0uyUlakW/74K")
	// 			.isEnabled(true)
	// 			.accountNoExpired(true)
	// 			.accountNoLocked(true)
	// 			.credentialsNoExpired(true)
	// 			.roles(Set.of(roleDeveloper))
	// 			.build();

				
	// 		userRespository.saveAll(List.of(userAlejandro,userAnyi,userDaniel,userSantiago));
	// 	};
	// }
}
