package com.kata.delivery.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.kata.delivery.infrastructure.entities.DeliveryEntity;

public interface DeliveryRepository extends ReactiveCrudRepository<DeliveryEntity, Long> {
}
