package com.kata.delivery.application.mappers;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.entities.DeliveryVo;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequestDTO;

@Component
public class DeliveryDtoMapper {
    public DeliveryDto toDto(DeliveryVo vo) {
        if (vo == null) {
            return null;
        }
        return new DeliveryDto(vo.getId(), vo.getTimeslotId(), vo.getClient());
    }

    public DeliveryVo toVo(DeliveryDto dto) {
        if (dto == null) {
            return null;
        }
        return new DeliveryVo(dto.getId(), dto.getTimeslotId(), dto.getClient());
    }

    public DeliveryVo toVo(DeliveryRequestDTO request) {
        if (request == null) {
            return null;
        }
        return new DeliveryVo(null, request.getTimeslotId(), request.getClient());
    }
}
