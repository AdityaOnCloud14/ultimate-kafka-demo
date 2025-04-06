package com.example.customeraccountstatechange;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountStateChange {
    @Id
    private String customerId;
    private String state;
    
    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
