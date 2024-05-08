package com.firstbootapp.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.firstbootapp.em")
public class EmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmApplication.class, args);
	}

}
