package com.example.customeraccountstatechange;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountStateChangeListener {

    private final AccountStateChangeRepository accountStateChangeRepository;

    public AccountStateChangeListener(AccountStateChangeRepository accountStateChangeRepository) {
        this.accountStateChangeRepository = accountStateChangeRepository;
    }

    @KafkaListener(topics = "account-state-change", groupId = "account-state-change-group", errorHandler = "kafkaErrorHandler")
    public void listen(@Payload AccountStateChangeEvent event) {
        // Validate required fields
        if (event.getCustomerId() == null || event.getState() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing customerId or state");
        }
        // Map event to entity and save to DB
        AccountStateChange accountStateChange = new AccountStateChange();
        accountStateChange.setCustomerId(event.getCustomerId());
        accountStateChange.setState(event.getState());
        accountStateChangeRepository.save(accountStateChange);
    }
}
