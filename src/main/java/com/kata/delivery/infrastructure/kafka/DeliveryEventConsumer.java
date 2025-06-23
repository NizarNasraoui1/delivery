package com.kata.delivery.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.kata.delivery.domain.repositories.TimeslotCrudService;

@Component
@RequiredArgsConstructor
public class DeliveryEventConsumer {

    private final TimeslotCrudService timeslotCrudService;

    @KafkaListener(topics = "${kafka.topic.delivery-booked}", groupId = "delivery-service")
    public void handleDeliveryBooked(DeliveryEvent event) {
        timeslotCrudService.deleteById(event.getTimeslotId()).subscribe();
    }
}
