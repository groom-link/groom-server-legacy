package com.example.groom.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class TeamSchedule extends Schedule {

    @Embedded
    private MeetingLocation meetingLocation;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}

