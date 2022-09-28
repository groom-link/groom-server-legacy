package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.entity.domain.schedule.MeetingLocation;
import lombok.Data;

@Data
public class TeamSchedulePostDto extends ScheduleDto {

    private MeetingLocation meetingLocation;

    private Long roomId;
}
