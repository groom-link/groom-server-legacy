package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamSchedulePostDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamScheduleService {

    private final TeamScheduleRepository teamScheduleRepository;

    public TeamSchedule createTeamSchedule(TeamSchedulePostDto teamSchedulePostDto) {
        TeamScheduleDto teamScheduleDto = new TeamScheduleDto(teamSchedulePostDto);

        TeamSchedule teamSchedule = TeamSchedule.of(teamScheduleDto);

        teamScheduleRepository.save(teamSchedule);

        // 팀 스케줄 참여자 중간테이블 생성
        // userTeamScheduleRepository.save(UserTeamSchedule.of(teamSchedule, teamSchedulePostDto.getOwnerId(), RequestStatus.ACCEPT));

        return teamSchedule;
    }

    public void deleteTeamSchedule(Long id) {
        if (teamScheduleRepository.existsById(id)) {
            teamScheduleRepository.deleteById(id);
        } else {
            throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
        }
    }

    public void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status) {
        teamScheduleRepository.updateParticipation(teamScheduleId, userId, status);
    }

    public Slice<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        return teamScheduleRepository.searchByCondition(pageable, teamScheduleSearchCondition);
    }

    public List<Long> getParticipants(Long teamScheduleId) {
        return teamScheduleRepository.getParticipants(teamScheduleId);
    }
}
