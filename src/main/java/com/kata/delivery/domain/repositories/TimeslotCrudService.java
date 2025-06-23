package com.kata.delivery.domain.repositories;

import java.time.LocalDate;

import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.domain.entities.TimeslotVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TimeslotCrudService {
    Flux<TimeslotVo> findByModeAndDate(DeliveryMode mode, LocalDate date);

    Mono<TimeslotVo> findById(Long id);

    Mono<TimeslotVo> save(TimeslotVo timeslotVo);

    Mono<Void> deleteById(Long id);
}
