package com.kata.delivery.application.mapper;

import org.springframework.stereotype.Component;
import com.kata.delivery.domain.Delivery;
import com.kata.delivery.exposition.dto.DeliveryDto;
import com.kata.delivery.exposition.dto.DeliveryRequest;

@Component
public class DeliveryDtoMapper {
    public DeliveryDto toDto(Delivery vo) {
        if (vo == null) {
            return null;
        }
        return new DeliveryDto(vo.getId(), vo.getTimeslotId(), vo.getClient());
    }

    public Delivery toVo(DeliveryDto dto) {
        if (dto == null) {
            return null;
        }
        return new Delivery(dto.getId(), dto.getTimeslotId(), dto.getClient());
    }

    public Delivery toVo(DeliveryRequest request) {
        if (request == null) {
            return null;
        }
        return new Delivery(null, request.getTimeslotId(), request.getClient());
    }
}
