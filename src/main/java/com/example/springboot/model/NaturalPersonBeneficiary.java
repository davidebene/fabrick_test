package com.example.springboot.model;

public class NaturalPersonBeneficiary {
    private String fiscalCode1;
    private String fiscalCode2 = null;
    private String fiscalCode3 = null;
    private String fiscalCode4 = null;
    private String fiscalCode5 = null;


    // Getter Methods

    public String getFiscalCode1() {
        return fiscalCode1;
    }

    public String getFiscalCode2() {
        return fiscalCode2;
    }

    public String getFiscalCode3() {
        return fiscalCode3;
    }

    public String getFiscalCode4() {
        return fiscalCode4;
    }

    public String getFiscalCode5() {
        return fiscalCode5;
    }

    // Setter Methods

    public void setFiscalCode1(String fiscalCode1) {
        this.fiscalCode1 = fiscalCode1;
    }

    public void setFiscalCode2(String fiscalCode2) {
        this.fiscalCode2 = fiscalCode2;
    }

    public void setFiscalCode3(String fiscalCode3) {
        this.fiscalCode3 = fiscalCode3;
    }

    public void setFiscalCode4(String fiscalCode4) {
        this.fiscalCode4 = fiscalCode4;
    }

    public void setFiscalCode5(String fiscalCode5) {
        this.fiscalCode5 = fiscalCode5;
    }
}
