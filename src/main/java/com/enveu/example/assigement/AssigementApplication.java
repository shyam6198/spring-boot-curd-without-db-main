package com.enveu.example.assigement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@Author Manish Kumar*/
@SpringBootApplication
public class AssigementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssigementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
	}
}
