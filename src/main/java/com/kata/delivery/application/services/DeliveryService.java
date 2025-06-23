package com.kata.delivery.application.services;

import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequestDTO;
import com.kata.delivery.exposition.dto.TimeslotDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface DeliveryService {
    Flux<TimeslotDto> getAvailableTimeslots(DeliveryMode mode, LocalDate date);
    Mono<TimeslotDto> addTimeslot(TimeslotDto timeslotDto);
    Mono<DeliveryDto> book(DeliveryRequestDTO request);
}
