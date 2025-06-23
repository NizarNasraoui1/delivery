package com.kata.delivery.domain.mapper;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.Delivery;
import com.kata.delivery.infrastructure.entity.DeliveryEntity;

@Component
public class DeliveryEntityMapper {
    public DeliveryEntity toEntity(Delivery vo) {
        if (vo == null) {
            return null;
        }
        return new DeliveryEntity(vo.getId(), vo.getTimeslotId(), vo.getClient());
    }

    public Delivery toVo(DeliveryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Delivery(entity.getId(), entity.getTimeslotId(), entity.getClient());
    }
}
