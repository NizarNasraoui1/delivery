package com.kata.delivery.exposition.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotDto {
    private Long id;
    private DeliveryMode mode;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
