package com.example.groom.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Schedule extends OwnEntity {

    @Column
    private String title;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;
}

