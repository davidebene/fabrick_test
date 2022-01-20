package com.example.springboot.model;

public class AccountBalance extends BaseEntity<AccountBalance> {
    private String date;
    private Long balance;
    private Long availableBalance;
    private String currency;


    // Getter Methods

    public String getDate() {
        return date;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    // Setter Methods

    public void setDate(String date) {
        this.date = date;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
