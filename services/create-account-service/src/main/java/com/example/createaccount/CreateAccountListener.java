package com.example.createaccount;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountListener {

    private final AccountRepository accountRepository;

    public CreateAccountListener(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @KafkaListener(topics = "create-account", groupId = "create-account-group", errorHandler = "kafkaErrorHandler")
    public void listen(@Payload CreateAccountEvent event) {
        // Validate required fields
        if (event.getCustomerId() == null || event.getEmail() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing customerId or email");
        }
        // Map event to entity and save to DB
        Account account = new Account();
        account.setCustomerId(event.getCustomerId());
        account.setName(event.getName());
        account.setEmail(event.getEmail());
        account.setDeviceType(event.getDeviceType());
        accountRepository.save(account);
    }
}
