package com.kata.delivery.infrastructure.repository;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.DeliveryMode;
import com.kata.delivery.domain.Timeslot;
import com.kata.delivery.domain.TimeslotRepository;
import com.kata.delivery.domain.mapper.TimeslotEntityMapper;

@Repository
@RequiredArgsConstructor
public class TimeslotRepositoryImpl implements TimeslotRepository {
    private final SpringTimeslotRepository springRepository;
    private final TimeslotEntityMapper mapper;

    @Override
    public Flux<Timeslot> findByModeAndDate(DeliveryMode mode, LocalDate date) {
        return springRepository.findByModeAndDate(mode, date)
                .map(mapper::toVo);
    }

    @Override
    public Mono<Timeslot> findById(Long id) {
        return springRepository.findById(id)
                .map(mapper::toVo);
    }

    @Override
    public Mono<Timeslot> save(Timeslot timeslot) {
        return springRepository.save(mapper.toEntity(timeslot))
                .map(mapper::toVo);
    }
}
