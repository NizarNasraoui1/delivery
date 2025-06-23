package com.kata.delivery.domain;

import reactor.core.publisher.Mono;

/**
 * Repository exposing domain {@link Delivery} value objects.
 */
public interface DeliveryRepository {
    Mono<Delivery> save(Delivery delivery);
}
