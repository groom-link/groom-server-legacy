package com.example.groom.domain.todo;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.todo.Repository.TodoRepository;
import com.example.groom.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo getTodo(Long id) {
        Optional<Todo> todo = this.todoRepository.findById(id);
        if(!todo.isPresent()) throw new CustomException(ErrorCode.TODO_NOT_FOUND);
        return todo.get();
    }

    public List<Todo> getTodoListByRoomId(Long id) {
        // 리스트는 널값 체크 안해도 됨
        return this.todoRepository.findAllByRoomId(id);
    }

    public Todo createTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Todo todo) {
        Todo existTodo = getTodo(todo.getId());

        existTodo.updateTodo(todo);

        return existTodo;
    }
}
