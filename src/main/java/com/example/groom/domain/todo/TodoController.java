package com.example.groom.domain.todo;

import com.example.groom.domain.todo.Dto.TodoDto;
import com.example.groom.domain.todo.Dto.TodoListResponseDto;
import com.example.groom.domain.todo.Dto.TodoSearchCondition;
import com.example.groom.entity.domain.todo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public TodoListResponseDto getTodoList(TodoSearchCondition todoSearchCondition, Pageable pageable) {
        return todoService.searchByCondition(todoSearchCondition, pageable);
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    // TodoResponseDto/TodoListResponseDto, room을 제외한 다른거는 id만 반환하도록(dto를 따로 만들어서)
    @DeleteMapping
    public Long deleteTodo(@RequestParam("todoId") Long id) {
        todoService.deleteTodo(id);
        return id;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody TodoDto todoDto, @PathVariable Long id) {
        return todoService.updateTodo(id, todoDto);
    }
}
