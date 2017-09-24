/**
 * 
 */
package com.microservicio.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ncarabali
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {
	
	public static void main(String[] args) {
		SpringApplication.run(RegistrationServer.class, args);
	}
	
	
	
}
