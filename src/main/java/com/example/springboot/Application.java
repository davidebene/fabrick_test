package com.example.springboot;

import java.util.Scanner;

import com.example.springboot.model.*;
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

            System.out.print("Enter your account Id: ");
            String accountId = scanner.next();

            AccountBalance balance = restTemplate.getForObject(
                    String.format("http://localhost:8080/account/%s/balance", accountId), AccountBalance.class);
            System.out.println(balance.getPayload().toString());

            AccountTransaction transactions = restTemplate.getForObject(
                    String.format("http://localhost:8080/account/%s/transactions", accountId), AccountTransaction.class);
            System.out.println(transactions.getPayload().toString());

            PaymentData data = new PaymentData();
            Creditor creditor = new Creditor();
            Account account = new Account();
            TaxRelief taxRelief = new TaxRelief();
            NaturalPersonBeneficiary naturalPersonBeneficiary = new NaturalPersonBeneficiary();
            LegalPersonBeneficiary legalPersonBeneficiary = new LegalPersonBeneficiary();

            System.out.print("NEW MONEY TRANSFER!\n");
            System.out.print("Enter creditor name: ");
            String creditorName = scanner.next();
            creditor.setName(creditorName);

            System.out.print("Enter creditor account code: ");
            String creditorAccountCode = scanner.next();
            account.setAccountCode(creditorAccountCode);
            creditor.setAccount(account);
            data.setCreditor(creditor);

            System.out.print("Enter transfer description: ");
            String description = scanner.next();
            data.setDescription(description);

            System.out.print("Enter transfer amount: ");
            String amount = scanner.next();
            data.setAmount(Long.valueOf(amount));

            System.out.print("Enter transfer currency: ");
            String currency = scanner.next();
            data.setCurrency(currency.toUpperCase());

            System.out.print("Is the tax relief is related to upgrades of common condominium spaces?: [Y/N] ");
            String isCondoUpgrade = scanner.next();
            if (isCondoUpgrade.toUpperCase().equals("Y")) {
                taxRelief.setIsCondoUpgrade(true);
            } else {
                taxRelief.setIsCondoUpgrade(false);
            }

            System.out.print("Enter creditor FiscalCode: ");
            String fiscalCode = scanner.next();
            taxRelief.setCreditorFiscalCode(fiscalCode);

            System.out.print("Enter beneficiary type: [NATURAL_PERSON/LEGAL_PERSON] ");
            String benType = scanner.next();
            taxRelief.setBeneficiaryType(benType);

            if(benType.toUpperCase().equals("NATURAL_PERSON")) {
				System.out.print("Enter beneficiary FiscalCode: ");
				String beneficiaryFiscalCode = scanner.next();
				naturalPersonBeneficiary.setFiscalCode1(beneficiaryFiscalCode);
			}
            else {
				System.out.print("Enter P.IVA: ");
				String piva = scanner.next();
				legalPersonBeneficiary.setFiscalCode(piva);
			}

			taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
            taxRelief.setLegalPersonBeneficiary(legalPersonBeneficiary);
            data.setTaxRelief(taxRelief);


            MoneyTransfer transfer = restTemplate.postForObject(
                    String.format("http://localhost:8080/account/%s/payments/money-transfers", accountId), data, MoneyTransfer.class);
            System.out.println(transfer.getPayload().toString());
        };
    }

}
