package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	apple a1;
	@Autowired
	apple a2;
	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
		// apple a=new apple();
		// a.callApple(); 
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hash code of a1: " + a1.hashCode());
        System.out.println("Hash code of a2: " + a2.hashCode());
		a1.callApple();
		
	}

	

}
