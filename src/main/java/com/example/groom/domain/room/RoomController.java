package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.TeamScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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


    @GetMapping
    public Slice<RoomDto> searchRoom(Pageable pageable, RoomSearchCondition roomSearchCondition) {
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

    @PostMapping
    public void postRoom(@RequestBody RoomPostDto roomPostDto) {
        this.roomService.postRoom(roomPostDto);
    }

}
