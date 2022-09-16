package com.example.groom.entity.domain.schedule;

import com.example.groom.entity.domain.room.Room;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class TeamSchedule extends Schedule {

    @Embedded
    private MeetingLocation meetingLocation;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}