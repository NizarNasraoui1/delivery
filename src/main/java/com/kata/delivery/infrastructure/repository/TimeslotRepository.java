package com.kata.delivery.infrastructure.repository;

import java.time.LocalDate;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.infrastructure.entities.TimeslotEntity;
import reactor.core.publisher.Flux;

public interface TimeslotRepository extends ReactiveCrudRepository<TimeslotEntity, Long> {
    Flux<TimeslotEntity> findByModeAndDate(DeliveryMode mode, LocalDate date);
}
