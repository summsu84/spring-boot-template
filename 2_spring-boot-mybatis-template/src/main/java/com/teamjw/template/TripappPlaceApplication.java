package com.teamjw.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripappPlaceApplication {

	public static void main(String[] args) {

		//System.out.println("gg" + System.getProperty("server.servlet.context-path"));
		//System.setProperty("server.servlet.context-path", "/api");
//		System.out.println("gg : " + System.getProperty("server.servlet.context-path"));
		SpringApplication.run(TripappPlaceApplication.class, args);
	}

}
