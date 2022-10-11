package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.entity.domain.room.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;


    @GetMapping
    public Slice<RoomListDto> searchRoom(Pageable pageable, RoomSearchCondition roomSearchCondition){
        return this.roomService.searchRooms(pageable, roomSearchCondition);
    }

    @GetMapping("/{id}")
    public RoomDetailDto getRoomDetail(@PathVariable("id") Long id){
        return this.roomService.getRoomDetailDtoByRoomId(id);
    }

    @PostMapping
    public Room postRoom(@RequestBody RoomPostDto roomPostDto){
        return this.roomService.postRoom(roomPostDto);
    }

}
