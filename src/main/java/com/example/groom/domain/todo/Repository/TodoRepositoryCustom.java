package com.example.groom.domain.todo.Repository;

import com.example.groom.domain.todo.Dto.TodoListResponseDto;
import com.example.groom.domain.todo.Dto.TodoSearchCondition;
import org.springframework.data.domain.Pageable;

public interface TodoRepositoryCustom {

    TodoListResponseDto searchByCondition(TodoSearchCondition todoSearchCondition, Pageable pageable);
}