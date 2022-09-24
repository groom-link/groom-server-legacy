package com.example.groom.domain.room.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.groom.entity.domain.room.QRoom.room;
import static com.example.groom.entity.domain.room.QRoomParticipants.roomParticipants;

@Data
public class RoomSearchCondition {

    private String name;
    private String summary;
    private String description;
    private List<String> Category;
    private LocalDateTime dateLoe;
    private LocalDateTime dateGoe;
    private Long participantsId;


    private BooleanBuilder nameContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!getName().isBlank())builder.and(room.name.contains(getName()));
        return builder;
    }

    private BooleanBuilder summaryContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!getSummary().isBlank())builder.and(room.summary.contains(getSummary()));
        return builder;
    }
    private BooleanBuilder descriptionContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!getDescription().isBlank())builder.and(room.description.contains(getDescription()));
        return builder;
    }

    private BooleanBuilder categoryIn(){
        BooleanBuilder builder = new BooleanBuilder();
        if(getCategory() != null && getCategory().size() > 0)builder.and(room.category.name.in(getCategory()));
        return builder;
    }

    private BooleanBuilder participantsHave(){
        BooleanBuilder builder = new BooleanBuilder();
        if(getParticipantsId() != null)builder.and(
                JPAExpressions.select(
                        roomParticipants.userInfo.id)
                        .from(roomParticipants)
                        .where(roomParticipants.room.id.eq(room.id)).contains(getParticipantsId())
        );
        return builder;
    }

    public BooleanBuilder getCondition(){
        return new BooleanBuilder().and(summaryContains())
                .and(nameContains())
                .and(descriptionContains())
                .and(categoryIn())
                .and(participantsHave());
    }
}
