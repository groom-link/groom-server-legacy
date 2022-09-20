package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.entity.domain.room.Room;
import com.example.groom.entity.domain.schedule.MeetingLocation;
import lombok.Data;

@Data
public class TeamScheduleDto {

    private MeetingLocation meetingLocation;

    private Long roomId;

    private Room room;
}
