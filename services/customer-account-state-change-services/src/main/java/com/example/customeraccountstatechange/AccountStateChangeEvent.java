package com.example.customeraccountstatechange;

public class AccountStateChangeEvent {
    private String customerId;
    private String state;
    
    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
