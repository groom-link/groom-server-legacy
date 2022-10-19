package com.example.groom.domain.schedule.personalSchedule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonalScheduleDto {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
