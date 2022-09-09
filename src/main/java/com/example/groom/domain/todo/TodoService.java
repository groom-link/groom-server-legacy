package com.example.groom.domain.todo;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.todo.Repository.TodoRepository;
import com.example.groom.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo getTodo(Long id) {
        Todo todo = this.todoRepository.findById(id).orElseThrow(e->CustomException(ErrorCode.TODO_NOT_FOUND))
        return todo.get();
    }

    public Slice<Todo> getTodoListByRoomId(Long id, Pageable pageable) {
        // 리스트는 널값 체크 안해도 됨
        return this.todoRepository.findAllByRoomId(id, pageable);
    }

    @Transactional
    public Slice<Todo> getTodoListByUserInfoRoomId(Long roomId, Long userInfoId, Pageable pageable) {
        return this.todoRepository.findAllByUserIdRoomId(roomId, userInfoId, pageable);
    }

    public Todo createTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = getTodo(id);

        this.todoRepository.delete(todo);
    }

    @Transactional
    public Todo updateTodo(Todo todo) {
        Todo existTodo = getTodo(todo.getId());

        existTodo.updateTodo(todo);

        return existTodo;
    }
}
