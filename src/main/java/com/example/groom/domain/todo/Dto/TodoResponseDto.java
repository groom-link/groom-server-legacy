package com.example.groom.domain.todo.Dto;

import com.example.groom.common.ResponseDto;
import com.example.groom.entity.Todo;

import javax.annotation.Nullable;

public class TodoResponseDto extends ResponseDto<Todo> {
    public TodoResponseDto(@Nullable Todo data) { super(data); }
}
