package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.entity.domain.schedule.MeetingLocation;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamScheduleDto {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
    private MeetingLocation meetingLocation;

    public TeamScheduleDto(TeamSchedulePostDto teamSchedulePostDto) {
        this.title = teamSchedulePostDto.getTitle();
        this.startTime = teamSchedulePostDto.getStartTime();
        this.endTime = teamSchedulePostDto.getEndTime();
        this.meetingLocation = teamSchedulePostDto.getMeetingLocation();
    }
}
