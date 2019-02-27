package io.cjet.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class (entry point) of this application.
 * 
 * Spring boot starting:
 * 1) Sets up default configuration (80%)
 * 2) Starts Spring application context
 * 3) Performs class path scan
 * 4) Starts Tomcat server
 * 
 * @author wudc
 *
 */

//tell spring this is a spring boot application
@SpringBootApplication
public class CjetDemoApp {
	public static void main(String[] args) {
		//boostrap a Spring application
		SpringApplication.run(CjetDemoApp.class, args);	
	}
}
