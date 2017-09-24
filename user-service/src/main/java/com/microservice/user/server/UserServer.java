/**
 * 
 */
package com.microservice.user.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Ncarabali
 *
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class UserServer {
 
    public static void main(String[] args) {
        SpringApplication.run(UserServer.class, args);
    }
}