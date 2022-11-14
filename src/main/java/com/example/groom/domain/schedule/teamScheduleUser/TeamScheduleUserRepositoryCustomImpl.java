package com.example.groom.domain.schedule.teamScheduleUser;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.example.groom.entity.domain.schedule.QTeamScheduleUser.teamScheduleUser;

public class TeamScheduleUserRepositoryCustomImpl implements TeamScheduleUserRepositoryCustom {

    private final JPAQueryFactory query;

    @Autowired
    private EntityManager em;

    public TeamScheduleUserRepositoryCustomImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public void deleteByParticipantIdAndTeamScheduleId(Long participantId, Long teamScheduleId) {
        query.delete(teamScheduleUser)
                .where(teamScheduleUser.participant.id.eq(participantId))
                .where(teamScheduleUser.teamSchedule.id.eq(teamScheduleId))
                .execute();
    }
}
