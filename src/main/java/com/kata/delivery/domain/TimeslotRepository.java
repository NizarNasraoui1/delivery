package com.kata.delivery.domain;

import java.time.LocalDate;
import reactor.core.publisher.Flux;

/**
 * Repository exposing domain {@link Timeslot} value objects.
 */
public interface TimeslotRepository {
    Flux<Timeslot> findByModeAndDate(DeliveryMode mode, LocalDate date);
}
