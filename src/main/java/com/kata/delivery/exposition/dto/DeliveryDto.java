package com.kata.delivery.exposition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private Long id;
    private Long timeslotId;
    private String client;
}
