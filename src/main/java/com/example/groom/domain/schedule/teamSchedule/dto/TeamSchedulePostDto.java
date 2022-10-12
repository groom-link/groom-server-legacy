package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.entity.domain.schedule.MeetingLocation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TeamSchedulePostDto {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private MeetingLocation meetingLocation;

    // 참가 유저 리스트
    private List<Long> participantsIds;
}
