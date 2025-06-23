package com.kata.delivery.infrastructure.repository.impl;

import com.kata.delivery.infrastructure.repository.DeliveryRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.domain.repositories.DeliveryCrudService;
import com.kata.delivery.domain.mappers.DeliveryEntityMapper;

@Repository
@RequiredArgsConstructor
public class DeliveryCrudServiceImpl implements DeliveryCrudService {
    private final DeliveryRepository springRepository;
    private final DeliveryEntityMapper mapper;

    @Override
    public Mono<DeliveryVo> save(DeliveryVo deliveryVo) {
        return springRepository.save(mapper.toEntity(deliveryVo))
                .map(mapper::toVo);
    }
}
