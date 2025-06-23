package com.kata.delivery.application;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kata.delivery.application.DeliveryService;
import com.kata.delivery.application.exception.TimeslotUnavailableException;
import com.kata.delivery.application.mapper.DeliveryDtoMapper;
import com.kata.delivery.application.mapper.TimeslotDtoMapper;
import com.kata.delivery.domain.Delivery;
import com.kata.delivery.domain.DeliveryRepository;
import com.kata.delivery.domain.DeliveryMode;
import com.kata.delivery.domain.Timeslot;
import com.kata.delivery.domain.TimeslotRepository;
import com.kata.delivery.exposition.dto.DeliveryRequest;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class DeliveryServiceTest {

    @Mock
    private TimeslotRepository timeslotRepository;
    @Mock
    private DeliveryRepository deliveryRepository;

    private DeliveryService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new DeliveryService(timeslotRepository, deliveryRepository, new TimeslotDtoMapper(), new DeliveryDtoMapper());
    }

    @Test
    void bookShouldFailWhenTimeslotMissing() {
        DeliveryRequest request = new DeliveryRequest(1L, "client");
        when(timeslotRepository.findById(1L)).thenReturn(Mono.empty());

        StepVerifier.create(service.book(request))
            .expectError(TimeslotUnavailableException.class)
            .verify();
    }

    @Test
    void bookShouldSucceedWhenTimeslotExists() {
        DeliveryRequest request = new DeliveryRequest(1L, "client");
        Timeslot slot = new Timeslot(1L, DeliveryMode.DELIVERY, LocalDate.now(), LocalTime.NOON, LocalTime.NOON.plusHours(1));
        when(timeslotRepository.findById(1L)).thenReturn(Mono.just(slot));
        Delivery delivery = new Delivery(null, 1L, "client");
        when(deliveryRepository.save(delivery)).thenReturn(Mono.just(new Delivery(10L, 1L, "client")));

        StepVerifier.create(service.book(request))
            .expectNextMatches(d -> d.getId() == 10L)
            .verifyComplete();
    }
}
