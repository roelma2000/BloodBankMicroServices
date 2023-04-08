package com.assignment4.seekermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeekermicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekermicroserviceApplication.class, args);
	}

}
