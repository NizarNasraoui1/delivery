package com.kata.delivery.infrastructure.repository.impl;

import java.time.LocalDate;

import com.kata.delivery.infrastructure.repository.TimeslotRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.domain.repositories.TimeslotCrudService;
import com.kata.delivery.domain.mappers.TimeslotEntityMapper;

@Repository
@RequiredArgsConstructor
public class TimeslotCrudServiceImpl implements TimeslotCrudService {
    private final TimeslotRepository springRepository;
    private final TimeslotEntityMapper mapper;

    @Override
    public Flux<TimeslotVo> findByModeAndDate(DeliveryMode mode, LocalDate date) {
        return springRepository.findByModeAndDate(mode, date)
                .map(mapper::toVo);
    }

    @Override
    public Mono<TimeslotVo> findById(Long id) {
        return springRepository.findById(id)
                .map(mapper::toVo);
    }

    @Override
    public Mono<TimeslotVo> save(TimeslotVo timeslotVo) {
        return springRepository.save(mapper.toEntity(timeslotVo))
                .map(mapper::toVo);
    }
}
