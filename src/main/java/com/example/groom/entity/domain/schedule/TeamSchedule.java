package com.example.groom.entity.domain.schedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue(value = "teamSchedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSchedule extends Schedule {

    @Embedded
    private MeetingLocation meetingLocation;

    protected TeamSchedule(TeamScheduleDto teamScheduleDto) {
        this.meetingLocation = teamScheduleDto.getMeetingLocation();
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