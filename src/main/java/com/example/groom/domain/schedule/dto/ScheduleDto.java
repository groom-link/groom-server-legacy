package com.example.groom.domain.schedule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
