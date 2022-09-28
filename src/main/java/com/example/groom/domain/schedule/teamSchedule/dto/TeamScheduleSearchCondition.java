package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.entity.domain.room.Room;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamScheduleSearchCondition {
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
