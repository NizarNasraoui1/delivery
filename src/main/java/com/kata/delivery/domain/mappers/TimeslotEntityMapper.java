package com.kata.delivery.domain.mappers;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.infrastructure.entities.TimeslotEntity;

@Component
public class TimeslotEntityMapper {
    public TimeslotEntity toEntity(TimeslotVo vo) {
        if (vo == null) {
            return null;
        }
        return new TimeslotEntity(vo.getId(), vo.getMode(), vo.getDate(), vo.getStartTime(), vo.getEndTime());
    }

    public TimeslotVo toVo(TimeslotEntity entity) {
        if (entity == null) {
            return null;
        }
        return new TimeslotVo(entity.getId(), entity.getMode(), entity.getDate(), entity.getStartTime(), entity.getEndTime());
    }
}
