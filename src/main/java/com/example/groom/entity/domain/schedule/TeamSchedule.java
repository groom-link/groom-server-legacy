package com.example.groom.entity.domain.schedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.entity.domain.room.Room;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@DiscriminatorValue(value = "teamSchedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSchedule extends Schedule {

    @Embedded
    private MeetingLocation meetingLocation;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    protected TeamSchedule(TeamScheduleDto teamScheduleDto) {
        this.meetingLocation = teamScheduleDto.getMeetingLocation();
        this.room = Room.of(teamScheduleDto.getRoomId());
    }

    public TeamSchedule(Long id) {
        super(id);
    }

    static public TeamSchedule of(TeamScheduleDto teamScheduleDto) {
        return new TeamSchedule(teamScheduleDto);
    }

    static public TeamSchedule of(Long id) {
        return new TeamSchedule(id);
    }
}