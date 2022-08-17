package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.Todo;

import java.util.List;

public interface TodoRepositoryCustom {
    List<Todo> findAllByUserIdRoomId(Long roomId, Long userId);
}