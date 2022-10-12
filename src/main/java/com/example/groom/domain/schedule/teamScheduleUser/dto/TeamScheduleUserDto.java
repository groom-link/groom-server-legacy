package com.example.groom.domain.schedule.teamScheduleUser.dto;

import com.example.groom.entity.enums.RequestStatus;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TeamScheduleUserDto {

    private Long teamScheduleId;

    private Long userId;

    private RequestStatus status;


}
