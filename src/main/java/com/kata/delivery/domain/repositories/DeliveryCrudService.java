package com.kata.delivery.domain.repositories;

import com.kata.delivery.domain.entities.DeliveryVo;
import reactor.core.publisher.Mono;


public interface DeliveryCrudService {
    Mono<DeliveryVo> save(DeliveryVo deliveryVo);
}
