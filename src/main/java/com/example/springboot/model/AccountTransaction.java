package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountTransaction extends BaseEntity<AccountTransaction> {
    private List<Transaction> list = new ArrayList<>();

    public List<Transaction> getList() {
        return list;
    }
    public void setList(List<Transaction> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Transaction List{" +
                list.stream()
                        .map(n -> String.valueOf(n))
                        .collect(Collectors.joining("-", "{", "}")) + "}";
    }
}
