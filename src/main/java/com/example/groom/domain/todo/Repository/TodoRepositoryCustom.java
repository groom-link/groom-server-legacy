package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.domain.todo.Todo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface TodoRepositoryCustom {
    Slice<Todo> findAllByUserIdRoomId(Long roomId, Long userId, Pageable pageable);

    Slice<Todo> findAllByRoomId(Long roomId, Pageable pageable);
}