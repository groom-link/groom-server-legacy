package com.example.groom.domain.todo.Dto;

import com.example.groom.common.ResponseDto;
import com.example.groom.entity.Todo;
import org.springframework.data.domain.Slice;

import javax.annotation.Nullable;

public class TodoListResponseDto extends ResponseDto<Slice<Todo>> {
    public TodoListResponseDto(@Nullable Slice<Todo> data) { super(data); }
}
