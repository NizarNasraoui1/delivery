package com.kata.delivery.domain.mappers;

import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import com.kata.delivery.infrastructure.entities.TimeslotEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeslotEntityMapperTest {
    private final TimeslotEntityMapper mapper = new TimeslotEntityMapper();

    @Test
    void toEntityAndBack() {
        TimeslotVo vo = new TimeslotVo(1L, DeliveryMode.DELIVERY, LocalDate.now(), LocalTime.NOON, LocalTime.NOON.plusHours(1));
        TimeslotEntity entity = mapper.toEntity(vo);
        assertEquals(vo.getId(), entity.getId());
        assertEquals(vo.getMode(), entity.getMode());
        assertEquals(vo.getDate(), entity.getDate());
        assertEquals(vo.getStartTime(), entity.getStartTime());
        assertEquals(vo.getEndTime(), entity.getEndTime());

        TimeslotVo converted = mapper.toVo(entity);
        assertEquals(vo, converted);
    }
}
