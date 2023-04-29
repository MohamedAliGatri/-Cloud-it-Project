package com.cloudit.project;

import com.cloudit.project.model.User;
import com.cloudit.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(final UserRepository userRepository, final PasswordEncoder passwordEncoder ){
		return args ->{
			User user = new User("Mohamedali", passwordEncoder.encode("dalidali") );
			User user1 = new User("mohamed", passwordEncoder.encode("dalidali") );
			userRepository.save(user);
			userRepository.save(user1);
		};
	}
}
