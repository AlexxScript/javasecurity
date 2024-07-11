package com.app;

import org.springframework.boot.SpringApplication;

public class TestSpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringSecurityAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
