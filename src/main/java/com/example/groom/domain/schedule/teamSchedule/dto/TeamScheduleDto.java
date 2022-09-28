package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.entity.domain.room.Room;
import com.example.groom.entity.domain.schedule.MeetingLocation;
import lombok.Data;

@Data
public class TeamScheduleDto extends ScheduleDto {

    private MeetingLocation meetingLocation;

    private Room room;

    public TeamScheduleDto(TeamSchedulePostDto teamSchedulePostDto, Room room) {
        super(teamSchedulePostDto);
        this.meetingLocation = teamSchedulePostDto.getMeetingLocation();
        this.room = room;
    }
}
