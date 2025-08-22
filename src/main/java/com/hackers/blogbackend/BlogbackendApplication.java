package com.hackers.blogbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogbackendApplication.class, args);
	}

}
