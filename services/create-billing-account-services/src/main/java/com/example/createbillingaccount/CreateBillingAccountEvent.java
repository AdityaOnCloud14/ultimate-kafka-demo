package com.example.createbillingaccount;

public class CreateBillingAccountEvent {
    private String customerId;
    private String name;
    private String email;
    private String deviceType;
    private String billingType;
    private String billingDate;
    private String billingMethod;   
    private String billingAmount;
    private String billingStatus;
    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public String getBillingType() { return billingType; }  
    public void setBillingType(String billingType) { this.billingType = billingType; }
    public String getBillingDate() { return billingDate; }
    public void setBillingDate(String billingDate) { this.billingDate = billingDate; }
    public String getBillingMethod() { return billingMethod; }
    public void setBillingMethod(String billingMethod) { this.billingMethod = billingMethod; }
    public String getBillingAmount() { return billingAmount; }
    public void setBillingAmount(String billingAmount) { this.billingAmount = billingAmount; }
    public String getBillingStatus() { return billingStatus; }
    public void setBillingStatus(String billingStatus) { this.billingStatus = billingStatus; }
}

