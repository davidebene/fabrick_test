package com.example.springboot.model;

public class Debtor {
    private String name;
    Account AccountObject;


    // Getter Methods

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return AccountObject;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Account accountObject) {
        this.AccountObject = accountObject;
    }
}
