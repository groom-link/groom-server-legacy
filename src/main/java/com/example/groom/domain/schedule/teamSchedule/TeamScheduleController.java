package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.*;
import com.example.groom.entity.enums.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team-schedule")
public class TeamScheduleController {

    private final TeamScheduleService teamScheduleService;

    @PostMapping
    public TeamScheduleDetailDto postTeamSchedule(@RequestBody TeamScheduleDto teamScheduleDto) {
        return teamScheduleService.createTeamSchedule(teamScheduleDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id) {

        teamScheduleService.deleteTeamSchedule(id);

        return id;
    }

    @PatchMapping
    public TeamScheduleDetailDto patchTeamSchedule(@RequestBody TeamScheduleUpdateDto teamScheduleUpdateDto) {
        return teamScheduleService.updateTeamSchedule(teamScheduleUpdateDto);
    }

    @PatchMapping("/{teamScheduleId}/participation/{userId}")
    public void updateParticipation(@PathVariable Long teamScheduleId, @PathVariable Long userId, @RequestParam RequestStatus status) {
        teamScheduleService.updateParticipation(teamScheduleId, userId, status);
    }

    @GetMapping
    public TeamScheduleListResponseDto searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        return teamScheduleService.searchByCondition(pageable, teamScheduleSearchCondition);
    }

    @GetMapping("/participants/{teamScheduleId}")
    public List<Long> getParticipants(@PathVariable Long teamScheduleId) {
        return teamScheduleService.getParticipants(teamScheduleId);
    }

    @GetMapping("/{teamScheduleId}")
    public TeamScheduleDetailDto getTeamSchedule(@PathVariable Long teamScheduleId) {
        return teamScheduleService.getTeamSchedule(teamScheduleId);
    }
}
