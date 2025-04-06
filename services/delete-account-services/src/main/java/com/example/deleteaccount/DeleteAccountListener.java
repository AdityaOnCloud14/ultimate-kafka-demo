package com.example.deleteaccount;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountListener {

    private final DeleteAccountRepository deleteAccountRepository;

    public DeleteAccountListener(DeleteAccountRepository deleteAccountRepository) {
        this.deleteAccountRepository = deleteAccountRepository;
    }

    @KafkaListener(topics = "delete-account", groupId = "delete-account-group", errorHandler = "kafkaErrorHandler")
    public void listen(@Payload DeleteAccountEvent event) {
        // Validate required fields
        if (event.getCustomerId() == null || event.getDeleteDate() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing customerId or deleteDate");
        }
        if (event.getPlanId() == null || event.getStatus() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing planId or status");
        }
        if (event.getActivationDate() == null || event.getStatus() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing activationDate or status");
        }
        if (event.getDeleteDate() == null || event.getStatus() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing deleteDate or status");
        }
        // Map event to entity and save to DB
        DeleteAccount deleteAccount = new DeleteAccount();
        deleteAccount.setCustomerId(event.getCustomerId());
        deleteAccount.setPlanId(event.getPlanId());
        deleteAccount.setActivationDate(event.getActivationDate());
        deleteAccount.setStatus(event.getStatus());
        deleteAccount.setDeleteDate(event.getDeleteDate());
        deleteAccountRepository.save(deleteAccount);
    }
}
