package com.kata.delivery.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryVo {
    private Long id;
    private Long timeslotId;
    private String client;
}
