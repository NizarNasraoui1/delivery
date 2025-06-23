package com.kata.delivery.infrastructure.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import com.kata.delivery.domain.enumerations.DeliveryMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("timeslot")
public class TimeslotEntity {
    @Id
    private Long id;
    private DeliveryMode mode;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
