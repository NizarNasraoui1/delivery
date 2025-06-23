package com.kata.delivery.application;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import com.kata.delivery.application.services.DeliveryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.kata.delivery.infrastructure.kafka.DeliveryEventProducer;

import com.kata.delivery.application.exception.TimeslotUnavailableException;
import com.kata.delivery.application.mappers.DeliveryDtoMapper;
import com.kata.delivery.application.mappers.TimeslotDtoMapper;
import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.domain.repositories.DeliveryCrudService;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.domain.repositories.TimeslotCrudService;
import com.kata.delivery.exposition.dto.DeliveryRequest;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class DeliveryVoServiceTest {

    @Mock
    private TimeslotCrudService timeslotCrudService;
    @Mock
    private DeliveryCrudService deliveryCrudService;
    @Mock
    private DeliveryEventProducer eventProducer;

    private DeliveryServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new DeliveryServiceImpl(timeslotCrudService, deliveryCrudService, new TimeslotDtoMapper(), new DeliveryDtoMapper(), eventProducer);
    }

    @Test
    void bookShouldFailWhenTimeslotMissing() {
        DeliveryRequest request = new DeliveryRequest(1L, "client");
        when(timeslotCrudService.findById(1L)).thenReturn(Mono.empty());

        StepVerifier.create(service.book(request))
            .expectError(TimeslotUnavailableException.class)
            .verify();
    }

    @Test
    void bookShouldSucceedWhenTimeslotExists() {
        DeliveryRequest request = new DeliveryRequest(1L, "client");
        TimeslotVo slot = new TimeslotVo(1L, DeliveryMode.DELIVERY, LocalDate.now(), LocalTime.NOON, LocalTime.NOON.plusHours(1));
        when(timeslotCrudService.findById(1L)).thenReturn(Mono.just(slot));
        DeliveryVo deliveryVo = new DeliveryVo(null, 1L, "client");
        when(deliveryCrudService.save(deliveryVo)).thenReturn(Mono.just(new DeliveryVo(10L, 1L, "client")));

        StepVerifier.create(service.book(request))
            .expectNextMatches(d -> d.getId() == 10L)
            .verifyComplete();
    }
}
