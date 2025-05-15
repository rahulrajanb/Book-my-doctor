package com.TekPyramid.BookMyDoctor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookMyDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyDoctorApplication.class, args);
	}


	@Bean
	public ApplicationRunner applicationRunner(){

		return args -> {
			System.out.println("Application runner executed");
		};

	}

	@Bean
	public CommandLineRunner commandLineRunner(){

		return  args -> {
			System.out.println("Command line executed");
		};

	}
}
