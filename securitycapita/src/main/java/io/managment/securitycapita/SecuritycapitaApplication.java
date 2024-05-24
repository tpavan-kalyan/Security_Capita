package io.managment.securitycapita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

@SpringBootApplication
public class SecuritycapitaApplication {

	private static final int STRENGTH = 12;
	public static void main(String[] args) {
		SpringApplication.run(SecuritycapitaApplication.class, args);
	}	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(STRENGTH);
	}
}
