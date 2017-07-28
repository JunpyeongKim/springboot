package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpecificationsApplication implements CommandLineRunner {
	@Autowired UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpecificationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User userJohn;
		User userTom;

		userJohn = new User();
		userJohn.setFirstName("John");
		userJohn.setLastName("Doe");
		userJohn.setEmail("john@doe.com");
		userJohn.setAge(22);
		repository.save(userJohn);

		userTom = new User();
		userTom.setFirstName("Tom");
		userTom.setLastName("Doe");
		userTom.setEmail("tom@doe.com");
		userTom.setAge(26);
		repository.save(userTom);
	}
}
