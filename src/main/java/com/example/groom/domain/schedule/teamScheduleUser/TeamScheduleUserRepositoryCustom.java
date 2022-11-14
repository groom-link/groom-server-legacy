package com.example.groom.domain.schedule.teamScheduleUser;

public interface TeamScheduleUserRepositoryCustom {
    void deleteByParticipantIdAndTeamScheduleId(Long participantId, Long teamScheduleId);
}
