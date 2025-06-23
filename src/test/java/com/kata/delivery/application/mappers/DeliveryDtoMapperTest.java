package com.kata.delivery.application.mappers;

import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryDtoMapperTest {
    private final DeliveryDtoMapper mapper = new DeliveryDtoMapper();

    @Test
    void toDtoAndBack() {
        DeliveryVo vo = new DeliveryVo(1L, 2L, "client");
        DeliveryDto dto = mapper.toDto(vo);
        assertEquals(vo.getId(), dto.getId());
        assertEquals(vo.getTimeslotId(), dto.getTimeslotId());
        assertEquals(vo.getClient(), dto.getClient());

        DeliveryVo converted = mapper.toVo(dto);
        assertEquals(vo, converted);
    }

    @Test
    void toVoFromRequest() {
        DeliveryRequest request = new DeliveryRequest(3L, "cli");
        DeliveryVo vo = mapper.toVo(request);
        assertNull(vo.getId());
        assertEquals(request.getTimeslotId(), vo.getTimeslotId());
        assertEquals(request.getClient(), vo.getClient());
    }
}
