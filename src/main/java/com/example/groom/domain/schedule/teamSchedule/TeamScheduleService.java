package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.room.RoomRepository;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamScheduleService {

    private final RoomRepository roomRepository;

    public TeamSchedule createTeamSchedule(TeamScheduleDto teamScheduleDto) {

        teamScheduleDto.setRoom();
    }
}
