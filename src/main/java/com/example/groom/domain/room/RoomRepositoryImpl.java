package com.example.groom.domain.room;

import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.room.roomParticipants.RoomParticipantsRepository;
import com.example.groom.entity.domain.auth.UserInfo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.domain.room.QRoom.room;


public class RoomRepositoryImpl implements RoomRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Autowired
    private RoomParticipantsRepository roomParticipantsRepository;
    private final JPAQueryFactory query;

    public RoomRepositoryImpl(EntityManager em){
        this.query = new JPAQueryFactory(em);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoomDetailDto getRoomDetailDtoByRoomId(Long id) {
        RoomDetailDto roomDetailDto =
                query
                .select(Projections.constructor
                        (RoomDetailDto.class, room.id, room.name, room.summary, room.description, room.mainImageUrl))
                .from(room)
                .where(room.id.eq(id))
                .fetchOne();

        List<UserInfo> participants = this.roomParticipantsRepository.getParticipantsListUserInfosByRoomId(id);
        roomDetailDto.setRoomParticipants(participants);

        return roomDetailDto;
    }

    @Override
    public Page<RoomDto> searchByCondition(Pageable pageable, RoomSearchCondition condition) {
        List<RoomDto> roomDtos = query
                .select(Projections.constructor(RoomDto.class,
                        room.id,
                        room.name,
                        room.summary,
                        room.maxPeople,
                        room.createdAt,
                        room.updatedAt,
                        room.roomParticipants.size(),
                        room.owner
                        ))
                .from(room)
                .where(room.name.contains(condition.getName()),
                        room.createdAt.between(condition.getDateGoe(), condition.getDateLoe()),
                        room.summary.contains(condition.getSummary()),
                        room.description.contains(condition.getDescription())
//                        room.category.in(condition.getCategory())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        int size = query
                .selectFrom(room)
                .where(room.name.contains(condition.getName()),
                        room.createdAt.between(condition.getDateGoe(), condition.getDateLoe()),
                        room.summary.contains(condition.getSummary()),
                        room.description.contains(condition.getDescription())
//                        room.category.in(condition.getCategory())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        return new PageImpl<>(roomDtos, pageable, size);
    }
}
