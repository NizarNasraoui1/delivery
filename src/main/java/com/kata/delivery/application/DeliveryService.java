package com.kata.delivery.application;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.Delivery;
import com.kata.delivery.domain.DeliveryMode;
import com.kata.delivery.domain.DeliveryRepository;
import com.kata.delivery.domain.Timeslot;
import com.kata.delivery.domain.TimeslotRepository;
import com.kata.delivery.application.mapper.DeliveryDtoMapper;
import com.kata.delivery.application.mapper.TimeslotDtoMapper;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequest;
import com.kata.delivery.exposition.dto.TimeslotDto;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final TimeslotRepository timeslotRepository;
    private final DeliveryRepository deliveryRepository;
    private final TimeslotDtoMapper timeslotMapper;
    private final DeliveryDtoMapper deliveryMapper;

    public Flux<TimeslotDto> availableTimeslots(DeliveryMode mode, LocalDate date) {
        return timeslotRepository.findByModeAndDate(mode, date)
                .map(timeslotMapper::toDto);
    }

    public Mono<DeliveryDto> book(DeliveryRequest request) {
        Delivery delivery = deliveryMapper.toVo(request);
        return deliveryRepository.save(delivery)
                .map(deliveryMapper::toDto);
    }
}
