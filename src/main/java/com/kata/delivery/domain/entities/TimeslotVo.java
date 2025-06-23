package com.kata.delivery.domain.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.kata.delivery.domain.enumerations.DeliveryMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotVo {
    private Long id;
    private DeliveryMode mode;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
