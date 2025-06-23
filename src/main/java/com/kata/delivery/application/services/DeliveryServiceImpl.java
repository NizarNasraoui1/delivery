package com.kata.delivery.application.services;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.domain.repositories.DeliveryCrudService;
import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.domain.repositories.TimeslotCrudService;
import com.kata.delivery.application.exception.TimeslotUnavailableException;
import com.kata.delivery.application.mappers.DeliveryDtoMapper;
import com.kata.delivery.application.mappers.TimeslotDtoMapper;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequest;
import com.kata.delivery.exposition.dto.TimeslotDto;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final TimeslotCrudService timeslotCrudService;
    private final DeliveryCrudService deliveryCrudService;
    private final TimeslotDtoMapper timeslotMapper;
    private final DeliveryDtoMapper deliveryMapper;

    public Flux<TimeslotDto> getAvailableTimeslots(DeliveryMode mode, LocalDate date) {
        return timeslotCrudService.findByModeAndDate(mode, date)
                .map(timeslotMapper::toDto);
    }

    public Mono<TimeslotDto> addTimeslot(TimeslotDto timeslotDto) {
        TimeslotVo timeslotVo = timeslotMapper.toVo(timeslotDto);
        return timeslotCrudService.save(timeslotVo)
                .map(timeslotMapper::toDto);
    }

    public Mono<DeliveryDto> book(DeliveryRequest request) {
        return timeslotCrudService.findById(request.getTimeslotId())
                .switchIfEmpty(Mono.error(new TimeslotUnavailableException("Timeslot not available")))
                .flatMap(ts -> {
                    DeliveryVo deliveryVo = deliveryMapper.toVo(request);
                    return deliveryCrudService.save(deliveryVo)
                            .map(deliveryMapper::toDto);
                });
    }
}
