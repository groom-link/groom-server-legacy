package com.example.groom.domain.room.dto;

import com.querydsl.core.BooleanBuilder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.groom.entity.domain.room.QRoom.room;

@Data
public class RoomSearchCondition {
    private String name;
    private String summary;
    private String description;
    private Boolean isMax;
    private List<Long> categoryIds;
    private LocalDateTime dateLoe;
    private LocalDateTime dateGoe;
    private Long participantsId;

    private BooleanBuilder nameContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!name.isBlank())builder.and(room.name.contains(name));
        return builder;
    }

    private BooleanBuilder createdAtBetween(){
        BooleanBuilder builder = new BooleanBuilder();
        if(dateGoe != null)builder.and(room.createdAt.after(dateGoe));
        if(dateLoe != null)builder.and(room.createdAt.before(dateLoe));
        return builder;
    }

    private BooleanBuilder summaryContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!summary.isBlank())builder.and(room.summary.contains(summary));
        return builder;
    }

    private BooleanBuilder descriptionContains(){
        BooleanBuilder builder = new BooleanBuilder();
        if(!description.isBlank())builder.and(room.description.contains(description));
        return builder;
    }
    public BooleanBuilder getCondition(){
        return new BooleanBuilder().and(nameContains()).and(createdAtBetween()).and(summaryContains()).and(descriptionContains());
    }

}
