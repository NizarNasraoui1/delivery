package com.kata.delivery.exposition;

import com.kata.delivery.application.services.DeliveryService;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequestDTO;
import com.kata.delivery.exposition.dto.TimeslotDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.when;

class DeliveryControllerTest {
    @Mock
    private DeliveryService service;
    private DeliveryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new DeliveryController(service);
    }

    @Test
    void timeslotsShouldReturnFluxFromService() {
        LocalDate date = LocalDate.now();
        TimeslotDto dto = new TimeslotDto(1L, DeliveryMode.DELIVERY, date, LocalTime.NOON, LocalTime.NOON.plusHours(1));
        when(service.getAvailableTimeslots(DeliveryMode.DELIVERY, date)).thenReturn(Flux.just(dto));

        StepVerifier.create(controller.timeslots(DeliveryMode.DELIVERY, date))
                .expectNext(dto)
                .verifyComplete();
    }

    @Test
    void addTimeslotShouldReturnMonoFromService() {
        TimeslotDto request = new TimeslotDto(null, DeliveryMode.DELIVERY, LocalDate.now(), LocalTime.NOON, LocalTime.NOON.plusHours(1));
        TimeslotDto result = new TimeslotDto(1L, request.getMode(), request.getDate(), request.getStartTime(), request.getEndTime());
        when(service.addTimeslot(request)).thenReturn(Mono.just(result));

        StepVerifier.create(controller.addTimeslot(request))
                .expectNext(result)
                .verifyComplete();
    }

    @Test
    void bookShouldReturnMonoFromService() {
        DeliveryRequestDTO request = new DeliveryRequestDTO(1L, "client");
        DeliveryDto result = new DeliveryDto(5L, 1L, "client");
        when(service.book(request)).thenReturn(Mono.just(result));

        StepVerifier.create(controller.book(request))
                .expectNext(result)
                .verifyComplete();
    }
}
