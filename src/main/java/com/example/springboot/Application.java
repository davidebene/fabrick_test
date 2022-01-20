package com.example.springboot;

import java.util.Scanner;

import com.example.springboot.controller.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private AccountController controller;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			Scanner scanner = new Scanner(System.in);

			//  prompt for the user's name
			System.out.print("Inserisci il numero conto di riferimento: ");

			// get their input as a String
			String accountId = scanner.next();
			System.out.println(controller.getAccountBalance(accountId));
			System.out.println(controller.getAccountTransactions(accountId));
		};
	}

}
