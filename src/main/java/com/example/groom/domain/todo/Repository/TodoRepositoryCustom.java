package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.Todo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface TodoRepositoryCustom {
    Slice<Todo> findAllByUserIdRoomId(Long roomId, Long userId, Pageable pageable);

    Slice<Todo> findAllByRoomId(Long roomId, Pageable pageable);
}