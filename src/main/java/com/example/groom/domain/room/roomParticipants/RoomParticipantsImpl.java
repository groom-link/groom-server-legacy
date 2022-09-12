package com.example.groom.domain.Room.RoomParticipants;

import com.example.groom.entity.UserInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.QKakaoInfo.kakaoInfo;
import static com.example.groom.entity.QRoomParticipants.roomParticipants;
import static com.example.groom.entity.QUserInfo.userInfo;


public class RoomParticipantsImpl implements RoomParticipantsCustom{

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RoomParticipantsImpl(EntityManager em){this.query = new JPAQueryFactory(em);}


    @Override
    public List<UserInfo> getParticipantsListUserInfosByRoomId(Long roomId) {
        List<UserInfo> userInfos = query
                .select(roomParticipants.userInfo)
                .from(roomParticipants)
                .leftJoin(roomParticipants.userInfo, userInfo)
                .fetchJoin()
                .leftJoin(roomParticipants.userInfo.kakao, kakaoInfo)
                .fetchJoin()
                .where(roomParticipants.room.id.eq(roomId))
                .fetch();
        return userInfos;
    }

    @Override
    public Long countParticipantsByRoomId(Long roomId) {
        return Long.valueOf(query.selectFrom(roomParticipants)
                .where(roomParticipants.room.id.eq(roomId))
                .fetch().size());
    }
}
