package com.realstatefinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.realstatefinal")
public class RealstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealstateApplication.class, args);
	}

}
