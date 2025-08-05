package com.db.db_springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@ComponentScan(basePackages = {"com.db.db_springcore", "com.dto"})
@EnableJpaRepositories(basePackages = "com.dto") // <-- THIS
@EntityScan(basePackages = "com.model")
public class DbSpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbSpringcoreApplication.class, args);
	}

}
