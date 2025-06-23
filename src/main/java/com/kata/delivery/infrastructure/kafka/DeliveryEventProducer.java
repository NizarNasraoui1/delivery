package com.kata.delivery.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryEventProducer {

    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    @Value("${kafka.topic.delivery-booked}")
    private String topic;

    public void sendDeliveryBooked(Long timeslotId) {
        DeliveryEvent event = new DeliveryEvent(timeslotId);
        kafkaTemplate.send(topic, event);
    }
}
