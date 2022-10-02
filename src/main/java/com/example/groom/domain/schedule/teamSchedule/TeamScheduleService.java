package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.room.RoomRepository;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamSchedulePostDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.room.Room;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamScheduleService {

    private final TeamScheduleRepository teamScheduleRepository;
    private final RoomRepository roomRepository;

    public TeamSchedule createTeamSchedule(TeamSchedulePostDto teamSchedulePostDto) {
        Room room = roomRepository.findById(teamSchedulePostDto.getRoomId()).orElseThrow(() -> new CustomException(ErrorCode.ROOM_NOT_FOUND));

        TeamScheduleDto teamScheduleDto = new TeamScheduleDto(teamSchedulePostDto, room);

        TeamSchedule teamSchedule = TeamSchedule.of(teamScheduleDto);

        return teamScheduleRepository.save(teamSchedule);
    }

    public void deleteTeamSchedule(Long id) {
        if (!teamScheduleRepository.existsById(id)) throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
        teamScheduleRepository.deleteById(id);
    }

    public void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status) {
        teamScheduleRepository.updateParticipation(teamScheduleId, userId, status);
    }

    public Slice<TeamSchedule> searchByUserId(Pageable pageable, Long userId) {
        return teamScheduleRepository.searchByUserId(pageable, userId);
    }

    public Slice<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        return teamScheduleRepository.searchByCondition(pageable, teamScheduleSearchCondition);
    }
}
