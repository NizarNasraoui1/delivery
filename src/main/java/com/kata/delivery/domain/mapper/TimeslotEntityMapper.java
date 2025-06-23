package com.kata.delivery.domain.mapper;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.Timeslot;
import com.kata.delivery.infrastructure.entity.TimeslotEntity;

@Component
public class TimeslotEntityMapper {
    public TimeslotEntity toEntity(Timeslot vo) {
        if (vo == null) {
            return null;
        }
        return new TimeslotEntity(vo.getId(), vo.getMode(), vo.getDate(), vo.getStartTime(), vo.getEndTime());
    }

    public Timeslot toVo(TimeslotEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Timeslot(entity.getId(), entity.getMode(), entity.getDate(), entity.getStartTime(), entity.getEndTime());
    }
}
