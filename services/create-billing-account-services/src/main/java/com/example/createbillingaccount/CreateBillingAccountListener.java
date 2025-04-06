package com.example.createbillingaccount;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class CreateBillingAccountListener {

    private final BillingAccountRepository billingAccountRepository;

    public CreateBillingAccountListener(BillingAccountRepository billingAccountRepository) {
        this.billingAccountRepository = billingAccountRepository;
    }

    @KafkaListener(topics = "create-billing-account", groupId = "create-billing-account-group", errorHandler = "kafkaErrorHandler")
    public void listen(@Payload CreateBillingAccountEvent event) {
        // Validate required fields
        if (event.getCustomerId() == null || event.getEmail() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing customerId or email");
        }
        if (event.getBillingType() == null || event.getBillingDate() == null || event.getBillingMethod() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing billingType, billingDate, or billingMethod");
        }
        if (event.getBillingDate() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing billingDate");
        }
        if (event.getBillingMethod() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing billingMethod");
        }
        if (event.getBillingAmount() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing billingAmount");
        }
        if (event.getBillingStatus() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing billingStatus");
        }
        
        // Map event to entity and save to DB
        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setCustomerId(event.getCustomerId());
        billingAccount.setName(event.getName());
        billingAccount.setEmail(event.getEmail());
        billingAccount.setDeviceType(event.getDeviceType());
        billingAccount.setBillingType(event.getBillingType());
        billingAccount.setBillingDate(event.getBillingDate());
        billingAccount.setBillingMethod(event.getBillingMethod());
        billingAccount.setBillingAmount(event.getBillingAmount());
        billingAccount.setBillingStatus(event.getBillingStatus());
        billingAccountRepository.save(billingAccount);
    }
}
