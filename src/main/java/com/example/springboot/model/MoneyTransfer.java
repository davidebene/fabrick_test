package com.example.springboot.model;

import java.util.ArrayList;

public class MoneyTransfer extends BaseEntity<MoneyTransfer>{
    private String moneyTransferId;
    private String status;
    private String direction;
    Creditor CreditorObject;
    Debtor DebtorObject;
    private String cro;
    private String uri;
    private String trn;
    private String description;
    private String createdDatetime;
    private String accountedDatetime;
    private String debtorValueDate;
    private String creditorValueDate;
    Amount AmountObject;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    ArrayList< Object > fees = new ArrayList < Object > ();
    private boolean hasTaxRelief;


    // Getter Methods

    public String getMoneyTransferId() {
        return moneyTransferId;
    }

    public String getStatus() {
        return status;
    }

    public String getDirection() {
        return direction;
    }

    public Creditor getCreditor() {
        return CreditorObject;
    }

    public Debtor getDebtor() {
        return DebtorObject;
    }

    public String getCro() {
        return cro;
    }

    public String getUri() {
        return uri;
    }

    public String getTrn() {
        return trn;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public String getAccountedDatetime() {
        return accountedDatetime;
    }

    public String getDebtorValueDate() {
        return debtorValueDate;
    }

    public String getCreditorValueDate() {
        return creditorValueDate;
    }

    public Amount getAmount() {
        return AmountObject;
    }

    public boolean getIsUrgent() {
        return isUrgent;
    }

    public boolean getIsInstant() {
        return isInstant;
    }

    public String getFeeType() {
        return feeType;
    }

    public String getFeeAccountId() {
        return feeAccountId;
    }

    public boolean getHasTaxRelief() {
        return hasTaxRelief;
    }

    // Setter Methods

    public void setMoneyTransferId(String moneyTransferId) {
        this.moneyTransferId = moneyTransferId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setCreditor(Creditor creditorObject) {
        this.CreditorObject = creditorObject;
    }

    public void setDebtor(Debtor debtorObject) {
        this.DebtorObject = debtorObject;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public void setAccountedDatetime(String accountedDatetime) {
        this.accountedDatetime = accountedDatetime;
    }

    public void setDebtorValueDate(String debtorValueDate) {
        this.debtorValueDate = debtorValueDate;
    }

    public void setCreditorValueDate(String creditorValueDate) {
        this.creditorValueDate = creditorValueDate;
    }

    public void setAmount(Amount amountObject) {
        this.AmountObject = amountObject;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public void setIsInstant(boolean isInstant) {
        this.isInstant = isInstant;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public void setHasTaxRelief(boolean hasTaxRelief) {
        this.hasTaxRelief = hasTaxRelief;
    }
}
