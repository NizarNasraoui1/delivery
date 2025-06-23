package com.kata.delivery.exposition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDTO {
    private Long timeslotId;
    private String client;
}
