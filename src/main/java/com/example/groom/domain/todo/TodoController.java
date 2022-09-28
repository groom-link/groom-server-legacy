package com.example.groom.domain.todo;

import com.example.groom.domain.todo.Dto.TodoDto;
import com.example.groom.entity.domain.todo.Todo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@Tag(name="todo controller", description = "할 일 관련 엔드포인트")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/room")
    public Slice<Todo> getRoomTodoList(@Parameter(description = "할 일 목록을 조회할 모임 id")
                                               @RequestParam("id") Long id, @RequestParam Pageable pageable) {
        return todoService.getTodoListByRoomId(id, pageable);
    }

    @GetMapping("/user")
    public Slice<Todo> getUserTodoList(@Parameter(description = "할 일 목록을 조회할 모임 id")
                                           @RequestParam("roomgId") Long roomgId,
                                               @Parameter(description = "할 일 목록을 조회할 유저 id")
                                           @RequestParam("userId") Long userInfoId,
                                               @RequestParam Pageable pageable) {
        return todoService.getTodoListByUserInfoRoomId(roomgId, userInfoId, pageable);
    }

    @PostMapping
    public Todo createTodo(@Parameter(description = "생성할 할 일")
                                          @RequestBody TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    // TodoResponseDto/TodoListResponseDto, room을 제외한 다른거는 id만 반환하도록(dto를 따로 만들어서)
    @DeleteMapping
    public Long deleteTodo(@Parameter(description = "삭제할 할 일 id")
                                           @RequestParam("todoId") Long id) {
        todoService.deleteTodo(id);
        return id;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@Parameter(description = "업데이트할 할 일")
    @RequestBody TodoDto todoDto, @PathVariable Long id) {
        return todoService.updateTodo(id, todoDto);
    }
}
