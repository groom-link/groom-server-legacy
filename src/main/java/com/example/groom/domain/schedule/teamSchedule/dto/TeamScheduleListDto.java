package com.example.groom.domain.schedule.teamSchedule.dto;

import com.example.groom.entity.domain.schedule.MeetingLocation;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamScheduleListDto {

    private String title;

    private LocalDateTime startTime;

    private MeetingLocation meetingLocation;

    private List<String> profiles;

    public static TeamScheduleListDto of(TeamSchedule teamSchedule) {
        List<String> profiles = teamSchedule.getRoom().getRoomParticipants().stream()
                .map(participant -> participant.getUserInfo().getKakao().getKakaoAccount().getProfile().getProfileImageUrl())
                .toList();

        return TeamScheduleListDto.builder()
                .title(teamSchedule.getTitle())
                .startTime(teamSchedule.getStartTime())
                .meetingLocation(teamSchedule.getMeetingLocation())
                .profiles(profiles)
                .build();
    }
}
