package com.example.groom.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
public class RoomIntroduction extends CoopEntity{
    @Column
    private String description;

    @Column
    private String mainImageUrl;

    @Column
    private String summary;
}
