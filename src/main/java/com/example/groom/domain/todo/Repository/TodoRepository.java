package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {

    List<Todo> findAllByRoomId(Long roomId);
}