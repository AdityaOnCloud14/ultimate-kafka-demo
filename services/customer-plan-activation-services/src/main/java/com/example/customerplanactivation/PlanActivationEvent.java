package com.example.customerplanactivation;

public class PlanActivationEvent {
    private String customerId;
    private String planId;
    private String activationDate;
    private String status;
    
    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getPlanId() { return planId; }
    public void setPlanId(String planId) { this.planId = planId; }
    public String getActivationDate() { return activationDate; }
    public void setActivationDate(String activationDate) { this.activationDate = activationDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
