package com.dev6.Webfoodapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfoodappApplication implements CommandLineRunner{

	@Autowired
	private CustomProperties props;

	public static void main(String[] args) {
		SpringApplication.run(WebfoodappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("API URL: " + props.getApiUrl());
	}

}
