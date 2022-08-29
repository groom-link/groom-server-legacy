package com.example.groom.entity;


import lombok.Getter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Room extends OwnEntity{
    @Column
    private String name;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private RoomCategory category;

    @Column
    private Long maxPeople;

    @Column
    private String description;

    @Column
    private String mainImageUrl;

    @Column
    private String summary;

    @OneToMany
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<RoomParticipants> roomParticipants = new ArrayList<>();
}
