package com.example.springboot;

import java.util.Scanner;

import com.example.springboot.model.AccountBalance;
import com.example.springboot.model.AccountTransaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx, RestTemplate restTemplate) {
		return args -> {

			Scanner scanner = new Scanner(System.in);

			//  prompt for the user's name
			System.out.print("Inserisci il numero conto di riferimento: ");

			// get their input as a String
			String accountId = scanner.next();

			AccountBalance balance = restTemplate.getForObject(
					String.format("http://localhost:8080/account/%s/balance", accountId), AccountBalance.class);
			System.out.println(balance.getPayload().toString());

			AccountTransaction transactions = restTemplate.getForObject(
					String.format("http://localhost:8080/account/%s/transactions", accountId), AccountTransaction.class);
			System.out.println(transactions.getPayload().toString());
		};
	}

}
