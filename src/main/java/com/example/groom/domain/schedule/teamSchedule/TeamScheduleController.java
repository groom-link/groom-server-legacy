package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleListDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room/schedule")
public class TeamScheduleController {

    private final TeamScheduleService teamScheduleService;

    @PostMapping
    public TeamSchedule postTeamSchedule(@RequestBody TeamScheduleDto teamScheduleDto) {
        return teamScheduleService.createTeamSchedule(teamScheduleDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id) {

        teamScheduleService.deleteTeamSchedule(id);

        return id;
    }

    @PatchMapping("/{teamScheduleId}/participation/{userId}")
    public void updateParticipation(@PathVariable Long teamScheduleId, @PathVariable Long userId, @RequestParam RequestStatus status) {
        teamScheduleService.updateParticipation(teamScheduleId, userId, status);
    }

    @GetMapping("/search")
    public Slice<TeamScheduleListDto> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        return teamScheduleService.searchByCondition(pageable, teamScheduleSearchCondition);
    }

    @GetMapping("/participants/{teamScheduleId}")
    public List<Long> getParticipants(@PathVariable Long teamScheduleId) {
        return teamScheduleService.getParticipants(teamScheduleId);
    }

    @GetMapping("/recommend/{roomId}")
    public List<ScheduleDto> getRecommendSchedule(@PathVariable Long roomId, @RequestParam LocalDate date) {
        return teamScheduleService.getRecommendSchedule(roomId, date);
    }
}
