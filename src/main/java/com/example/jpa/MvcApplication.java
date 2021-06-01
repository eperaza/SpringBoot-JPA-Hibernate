package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
/*
@EnableJpaRepositories(basePackages = {"com.example.springboot.jpa.repo"})
@ComponentScan(value = "com.example.springboot.jpa.*")
@EntityScan(basePackages = {"com.example.springboot.jpa.entities"})
*/
public class MvcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

}
