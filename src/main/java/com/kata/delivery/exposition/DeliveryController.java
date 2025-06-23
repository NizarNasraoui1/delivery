package com.kata.delivery.exposition;

import java.time.LocalDate;

import com.kata.delivery.application.services.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequest;
import com.kata.delivery.exposition.dto.TimeslotDto;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService service;

    @GetMapping("/timeslots")
    public Flux<TimeslotDto> timeslots(@RequestParam DeliveryMode mode, @RequestParam LocalDate date) {
        return service.getAvailableTimeslots(mode, date);
    }

    @PostMapping("/timeslots")
    public Mono<TimeslotDto> addTimeslot(@RequestBody TimeslotDto timeslot) {
        return service.addTimeslot(timeslot);
    }

    @PostMapping("/deliveries")
    public Mono<DeliveryDto> book(@RequestBody DeliveryRequest request) {
        return service.book(request);
    }
}
