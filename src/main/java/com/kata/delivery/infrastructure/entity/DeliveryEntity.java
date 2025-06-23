package com.kata.delivery.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("delivery")
public class DeliveryEntity {
    @Id
    private Long id;
    private Long timeslotId;
    private String client;
}
