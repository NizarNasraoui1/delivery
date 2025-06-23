package com.kata.delivery.application.mappers;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.entities.TimeslotVo;
import com.kata.delivery.exposition.dto.TimeslotDto;

@Component
public class TimeslotDtoMapper {
    public TimeslotDto toDto(TimeslotVo vo) {
        if (vo == null) {
            return null;
        }
        return new TimeslotDto(vo.getId(), vo.getMode(), vo.getDate(), vo.getStartTime(), vo.getEndTime());
    }

    public TimeslotVo toVo(TimeslotDto dto) {
        if (dto == null) {
            return null;
        }
        return new TimeslotVo(dto.getId(), dto.getMode(), dto.getDate(), dto.getStartTime(), dto.getEndTime());
    }
}
