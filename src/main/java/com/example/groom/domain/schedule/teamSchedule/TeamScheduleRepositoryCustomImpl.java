package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleListDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleListResponseDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.enums.RequestStatus;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.groom.entity.domain.auth.QUserInfo.userInfo;
import static com.example.groom.entity.domain.schedule.QTeamSchedule.teamSchedule;
import static com.example.groom.entity.domain.schedule.QTeamScheduleUser.teamScheduleUser;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;


public class TeamScheduleRepositoryCustomImpl implements TeamScheduleRepositoryCustom {

    private final JPAQueryFactory query;

    @Autowired
    private EntityManager em;

    public TeamScheduleRepositoryCustomImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public TeamScheduleListResponseDto searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        List<TeamScheduleListDto> content = query
                .from(teamScheduleUser)
                .innerJoin(teamSchedule)
                .on(teamScheduleUser.teamSchedule.id.eq(teamSchedule.id))
                .innerJoin(userInfo)
                .on(teamScheduleUser.participant.id.eq(userInfo.id))
                .where(eqUserId(teamScheduleSearchCondition.getUserId()),
                        eqRoomId(teamScheduleSearchCondition.getRoomId()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .transform(
                        groupBy(teamSchedule.id).list(
                                Projections.constructor(
                                        TeamScheduleListDto.class,
                                        teamSchedule.id,
                                        teamSchedule.title,
                                        teamSchedule.startTime,
                                        teamSchedule.meetingLocation,
                                        list(
                                                Projections.fields(
                                                                String.class,
                                                                userInfo.kakao.kakaoAccount.profile.profileImageUrl
                                                        )
                                                        .as("profiles")
                                        )
                                )
                        )
                );

        boolean isLast = getIsLast(content, pageable);

        return TeamScheduleListResponseDto.of(content, pageable.getPageNumber(), isLast);
    }


    @Override
    public void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status) {
        query.update(teamScheduleUser)
                .set(teamScheduleUser.status, status)
                .where(teamScheduleUser.id.eq(teamScheduleId), teamScheduleUser.participant.id.eq(userId))
                .execute();
    }

    @Override
    public List<Long> getParticipants(Long teamScheduleId) {
        return query.select(teamScheduleUser.participant.id)
                .from(teamScheduleUser)
                .where(teamScheduleUser.teamSchedule.id.eq(teamScheduleId))
                .fetch();
    }

    @Override
    public List<ScheduleDto> searchByCondition(TeamScheduleSearchCondition teamScheduleSearchCondition) {
        return query.select(Projections.constructor(ScheduleDto.class,
                        teamSchedule.startTime,
                        teamSchedule.endTime
                ))
                .from(teamSchedule)
                .where(eqUserId(teamScheduleSearchCondition.getUserId()),
                        eqRoomId(teamScheduleSearchCondition.getRoomId()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .fetch();
    }

    private <T> boolean getIsLast(List<T> content, Pageable pageable) {
        boolean isLast = true;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize());
            isLast = false;
        }
        return isLast;
    }

    private BooleanExpression betweenScheduleTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null) {
            return null;
        }
        if (endTime == null) {
            return null;
        }

        return teamSchedule.startTime.between(startTime, endTime)
                .or(teamSchedule.endTime.between(startTime, endTime));
    }

    private BooleanExpression eqRoomId(Long roomId) {
        if (roomId == null) {
            return null;
        }
        return teamSchedule.room.id.eq(roomId);
    }

    private BooleanExpression eqUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        return teamScheduleUser.participant.id.eq(userId);
    }
}
