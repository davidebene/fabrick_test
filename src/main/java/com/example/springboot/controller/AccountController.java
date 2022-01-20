package com.example.springboot.controller;

import com.example.springboot.model.AccountBalance;
import com.example.springboot.model.AccountTransaction;
import com.example.springboot.model.MoneyTransfer;
import com.example.springboot.model.PaymentData;
import com.example.springboot.service.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AccountController {

	@Autowired
	private RestService restService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/account/{accountId}/balance")
	public ResponseEntity<?> getAccountBalance(@PathVariable String accountId) throws JsonProcessingException {
		String path = String.format("%s/balance", accountId);
		String result = restService.getResponseEntity(path);

		AccountBalance accountBalance = new ObjectMapper().readValue(result, AccountBalance.class);

		return ok(accountBalance);
	}

	@GetMapping("/account/{accountId}/transactions")
	public ResponseEntity<?> getAccountTransactions(@PathVariable String accountId) throws JsonProcessingException {
		String path = String.format("%s/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01", accountId);

		String result = restService.getResponseEntity(path);

		AccountTransaction accountTransactions = new ObjectMapper().readValue(result, AccountTransaction.class);

		return ok(accountTransactions);
	}

	@PostMapping("/account/{accountId}/payments/money-transfers")
	public ResponseEntity<?> postMoneyTransfer(@PathVariable String accountId , @RequestBody PaymentData paymentData) throws JsonProcessingException {
		String path = String.format("%s/payments/money-transfers", accountId);

		String result = restService.postResponseEntity(path, paymentData);

		MoneyTransfer transfer = new ObjectMapper().readValue(result, MoneyTransfer.class);

		return ok(transfer);
	}

}
