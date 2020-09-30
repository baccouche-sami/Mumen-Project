package com.example.Mumen.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //  Enabling JPA Auditing

public class MumenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumenProjectApplication.class, args);
	}

}
