package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity<T> {
    private String status;
    private List<Object> error = new ArrayList<Object>();
    T payload;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Object> getError() {
        return error;
    }
    public void setError(List<Object> error) {
        this.error = error;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
}
