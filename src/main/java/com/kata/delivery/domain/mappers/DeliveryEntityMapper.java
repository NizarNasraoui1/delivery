package com.kata.delivery.domain.mappers;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.infrastructure.entities.DeliveryEntity;

@Component
public class DeliveryEntityMapper {
    public DeliveryEntity toEntity(DeliveryVo vo) {
        if (vo == null) {
            return null;
        }
        return new DeliveryEntity(vo.getId(), vo.getTimeslotId(), vo.getClient());
    }

    public DeliveryVo toVo(DeliveryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new DeliveryVo(entity.getId(), entity.getTimeslotId(), entity.getClient());
    }
}
