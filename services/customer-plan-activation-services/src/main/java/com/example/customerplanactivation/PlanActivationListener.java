package com.example.customerplanactivation;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PlanActivationListener {

    private final PlanActivationRepository planActivationRepository;

    public PlanActivationListener(PlanActivationRepository planActivationRepository) {
        this.planActivationRepository = planActivationRepository;
    }

    @KafkaListener(topics = "plan-activation", groupId = "plan-activation-group", errorHandler = "kafkaErrorHandler")
    public void listen(@Payload PlanActivationEvent event) {
        // Validate required fields
        if (event.getCustomerId() == null || event.getPlanId() == null) {
            throw new IllegalArgumentException("Invalid event payload: missing customerId or planId");
        }
        // Map event to entity and save to DB
        PlanActivation planActivation = new PlanActivation();
        planActivation.setCustomerId(event.getCustomerId());
        planActivation.setPlanId(event.getPlanId());
        planActivation.setActivationDate(event.getActivationDate());
        planActivation.setStatus(event.getStatus());
        planActivationRepository.save(planActivation);
    }
}
