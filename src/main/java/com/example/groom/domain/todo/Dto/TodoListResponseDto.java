package com.example.groom.domain.todo.Dto;

import com.example.groom.common.ResponseDto;
import com.example.groom.entity.Todo;

import javax.annotation.Nullable;
import java.util.List;

public class TodoListResponseDto extends ResponseDto<List<Todo>> {
    public TodoListResponseDto(@Nullable List<Todo> data) { super(data); }
}
