package com.kata.delivery.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.kata.delivery.infrastructure.entity.DeliveryEntity;

public interface SpringDeliveryRepository extends ReactiveCrudRepository<DeliveryEntity, Long> {
}
