package com.example.springboot.controller;

import com.example.springboot.model.AccountBalance;
import com.example.springboot.model.AccountTransaction;
import com.example.springboot.service.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AccountController {

	@Autowired
	private RestService restService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/account/balance/{accountId}")
	public ResponseEntity<?> getAccountBalance(@PathVariable String accountId) throws JsonProcessingException {
		String path = String.format("%s/balance", accountId);
		String result = restService.getResponseEntity(path);

		AccountBalance accountBalance = new ObjectMapper().readValue(result, AccountBalance.class);

		return ok(accountBalance);
	}

	@GetMapping("/account/transactions/{accountId}")
	public ResponseEntity<?> getAccountTransactions(@PathVariable String accountId) throws JsonProcessingException {
		String path = String.format("%s/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01", accountId);
		
		String result = restService.getResponseEntity(path);

		AccountTransaction accountTransactions = new ObjectMapper().readValue(result, AccountTransaction.class);

		return ok(accountTransactions);
	}

}
