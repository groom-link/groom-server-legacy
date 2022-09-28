package com.example.groom.domain.schedule.dto;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamSchedulePostDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public ScheduleDto(TeamSchedulePostDto teamSchedulePostDto) {
        this.title = teamSchedulePostDto.getTitle();
        this.startTime = teamSchedulePostDto.getStartTime();
        this.endTime = teamSchedulePostDto.getEndTime();
    }
}
