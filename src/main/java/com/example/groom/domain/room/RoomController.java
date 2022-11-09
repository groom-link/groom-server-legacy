package com.example.groom.domain.room;


import com.example.groom.common.auth.jwt.JwtAuthentication;
import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListResponseDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.room.roomInviteCode.dto.CodeDto;
import com.example.groom.domain.room.roomParticipants.dto.RoomParticipantsDto;
import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.dto.ScheduleResponseDto;
import com.example.groom.domain.schedule.teamSchedule.TeamScheduleService;
import com.example.groom.domain.schedule.unableSchedule.UnableScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    private final TeamScheduleService teamScheduleService;

    private final UnableScheduleService unableScheduleService;


    @GetMapping
    public RoomListResponseDto searchRoom(Pageable pageable, RoomSearchCondition roomSearchCondition) {
        return this.roomService.searchRooms(pageable, roomSearchCondition);
    }

    @GetMapping("/code/{code}")
    public RoomDetailDto joinRoomByCode(@PathVariable String code) {
        return this.roomService.joinRoomByCode(code);
    }

    @PostMapping("/participant")
    public Long addParticipant(@RequestBody RoomParticipantsDto roomParticipantsDto) {
        return this.roomService.addParticipant(roomParticipantsDto);
    }

    @GetMapping("/{id}")
    public RoomDetailDto getRoomDetail(@PathVariable("id") Long id) {
        return this.roomService.getRoomDetailDtoByRoomId(id);
    }

    @GetMapping("/{roomId}/schedule/recommend")
    public List<ScheduleDto> getRecommendSchedule(@PathVariable Long roomId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return teamScheduleService.getRecommendSchedule(roomId, date);
    }

    @GetMapping("/{roomId}/unable-schedule")
    public List<ScheduleResponseDto> getUnableSchedule(@PathVariable Long roomId) {
        return unableScheduleService.searchSortedUnableSchedule(roomId);
    }

    @GetMapping("/me")
    public RoomListResponseDto getMyRoomList(Pageable pageable, JwtAuthentication authentication) {
        return this.roomService.getMyRoomList(pageable, authentication.getPrincipal());
    }


    @PostMapping
    public CodeDto postRoom(@RequestBody RoomPostDto roomPostDto) {
        return this.roomService.postRoom(roomPostDto);
    }

}
