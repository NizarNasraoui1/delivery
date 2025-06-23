package com.kata.delivery.application.mappers;

import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.exposition.dto.TimeslotDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeslotDtoMapperTest {
    private final TimeslotDtoMapper mapper = new TimeslotDtoMapper();

    @Test
    void toDtoAndBack() {
        TimeslotVo vo = new TimeslotVo(1L, DeliveryMode.DELIVERY, LocalDate.now(), LocalTime.NOON, LocalTime.NOON.plusHours(1));
        TimeslotDto dto = mapper.toDto(vo);
        assertEquals(vo.getId(), dto.getId());
        assertEquals(vo.getMode(), dto.getMode());
        assertEquals(vo.getDate(), dto.getDate());
        assertEquals(vo.getStartTime(), dto.getStartTime());
        assertEquals(vo.getEndTime(), dto.getEndTime());

        TimeslotVo converted = mapper.toVo(dto);
        assertEquals(vo, converted);
    }
}
