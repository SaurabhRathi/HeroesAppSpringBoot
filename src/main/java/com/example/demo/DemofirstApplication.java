package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemofirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemofirstApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup(Object event){
		System.out.println("Spring boot running.....");
	}

}
