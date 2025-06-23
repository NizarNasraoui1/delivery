package com.kata.delivery.domain;

import java.time.LocalDate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository exposing domain {@link Timeslot} value objects.
 */
public interface TimeslotRepository {
    Flux<Timeslot> findByModeAndDate(DeliveryMode mode, LocalDate date);

    Mono<Timeslot> findById(Long id);

    Mono<Timeslot> save(Timeslot timeslot);
}
