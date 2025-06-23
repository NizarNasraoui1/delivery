package com.kata.delivery.domain.mappers;

import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.infrastructure.entities.DeliveryEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryEntityMapperTest {
    private final DeliveryEntityMapper mapper = new DeliveryEntityMapper();

    @Test
    void toEntityAndBack() {
        DeliveryVo vo = new DeliveryVo(1L, 2L, "client");
        DeliveryEntity entity = mapper.toEntity(vo);
        assertEquals(vo.getId(), entity.getId());
        assertEquals(vo.getTimeslotId(), entity.getTimeslotId());
        assertEquals(vo.getClient(), entity.getClient());

        DeliveryVo converted = mapper.toVo(entity);
        assertEquals(vo, converted);
    }
}
