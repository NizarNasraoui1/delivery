package com.kata.delivery.application.mapper;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.Timeslot;
import com.kata.delivery.exposition.dto.TimeslotDto;

@Component
public class TimeslotDtoMapper {
    public TimeslotDto toDto(Timeslot vo) {
        if (vo == null) {
            return null;
        }
        return new TimeslotDto(vo.getId(), vo.getMode(), vo.getDate(), vo.getStartTime(), vo.getEndTime());
    }

    public Timeslot toVo(TimeslotDto dto) {
        if (dto == null) {
            return null;
        }
        return new Timeslot(dto.getId(), dto.getMode(), dto.getDate(), dto.getStartTime(), dto.getEndTime());
    }
}
