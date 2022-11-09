package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListResponseDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.dto.ScheduleResponseDto;
import com.example.groom.domain.schedule.teamSchedule.TeamScheduleService;
import com.example.groom.domain.schedule.unableSchedule.UnableScheduleService;
import com.example.groom.entity.domain.room.Room;
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

    @PostMapping
    public Long postRoom(@RequestBody RoomPostDto roomPostDto) {
        Room room = this.roomService.postRoom(roomPostDto);
        return room.getId();
    }

}
