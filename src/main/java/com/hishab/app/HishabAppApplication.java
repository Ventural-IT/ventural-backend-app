package com.hishab.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.hishab.app.model.User;
import com.hishab.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class HishabAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(HishabAppApplication.class, args);
	}

	@Bean
	CommandLineRunner loadDatabase(UserRepository repository) {

		return (args) -> {
			// repository.save(new User(1L,"Julkar","Nain","nain.bjit@gmail.com", true));
			// repository.save(new User(2L, "Ashikur","Rahman","ashik.bjit@gmail.com",
			// true));

			for (User user : repository.findAll()) {
				log.info(user.getFirstName() + " : " + user.getLastName() + " : " + user.getEmail());
			}

		};
	}
}