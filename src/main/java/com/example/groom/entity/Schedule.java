package com.example.groom.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Schedule extends BaseEntity {

    @Column
    private String title;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String meetingLocation; // 미팅 일정이 아닌경우 null

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
