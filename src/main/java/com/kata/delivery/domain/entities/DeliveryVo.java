package com.kata.delivery.domain.entities;

/**
 * Delivery value object used inside the domain layer.
 */
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
