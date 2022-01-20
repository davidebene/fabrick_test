package com.example.springboot.model;

public class TransactionType {
    private String enumeration;
    private String value;


    // Getter Methods

    public String getEnumeration() {
        return enumeration;
    }

    public String getValue() {
        return value;
    }

    // Setter Methods

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
