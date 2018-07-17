package com.aulaangular5.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aulaangular5.helpdesk.api.Enumerator.ProfileEnum;
import com.aulaangular5.helpdesk.api.entity.User;
import com.aulaangular5.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class HelpadeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpadeskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUser(userRepository, passwordEncoder);
		};
	}
	
	private void initUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User find = userRepository.findByEmail("admin@helpdesk.com");
		if(find == null) {
			userRepository.save(admin);
		}
	}
}
