package com.kata.delivery.infrastructure.repository;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.Delivery;
import com.kata.delivery.domain.DeliveryRepository;
import com.kata.delivery.domain.mapper.DeliveryEntityMapper;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {
    private final SpringDeliveryRepository springRepository;
    private final DeliveryEntityMapper mapper;

    @Override
    public Mono<Delivery> save(Delivery delivery) {
        return springRepository.save(mapper.toEntity(delivery))
                .map(mapper::toVo);
    }
}
