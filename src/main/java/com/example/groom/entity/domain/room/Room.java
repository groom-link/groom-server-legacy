package com.example.groom.entity.domain.room;


import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.entity.common.OwnEntity;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends OwnEntity {
    @Column
    private String name;

//    @JoinColumn
//    @ManyToOne(fetch = FetchType.LAZY)
//    private RoomCategory category;

    @Column
    private Long maxPeople;

    @Column
    private String description;

    @Column
    private String mainImageUrl;

//    @Column
//    private String summary;

    @OneToMany
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<RoomParticipants> roomParticipants = new ArrayList<>();

    protected Room(Long roomId) {
        super(roomId);
    }

    static public Room of(RoomPostDto roomPostDto){
        return new Room(roomPostDto);
    }

    protected Room(RoomPostDto roomPostDto){
//        this.category = RoomCategory.of(roomPostDto.getRoomCategoryId());
        this.description = roomPostDto.getDescription();
        this.mainImageUrl = roomPostDto.getMainImageUrl();
//        this.summary = roomPostDto.getSummary();
        this.name = roomPostDto.getName();
        this.maxPeople = roomPostDto.getMaxPeople();
    }

    public static Room of(Long roomId) {
        return new Room(roomId);
    }
}
