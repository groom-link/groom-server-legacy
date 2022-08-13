package com.example.groom.domain.todo;

import com.example.groom.domain.todo.Dto.TodoResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@Tag(name="todo controller", description = "할 일 관련 엔드포인트")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public TodoResponseDto getRoomTodoList() {

    }

}
