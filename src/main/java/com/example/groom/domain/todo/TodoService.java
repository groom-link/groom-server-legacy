package com.example.groom.domain.todo;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.todo.Dto.TodoDto;
import com.example.groom.domain.todo.Dto.TodoListResponseDto;
import com.example.groom.domain.todo.Dto.TodoSearchCondition;
import com.example.groom.domain.todo.Repository.TodoRepository;
import com.example.groom.entity.domain.todo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo getTodo(Long id) {
        Todo todo = this.todoRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.TODO_NOT_FOUND));
        return todo;
    }

    public TodoListResponseDto searchByCondition(TodoSearchCondition todoSearchCondition, Pageable pageable) {
        // 리스트는 널값 체크 안해도 됨
        return this.todoRepository.searchByCondition(todoSearchCondition, pageable);
    }

    public Todo createTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.updateTodo(todoDto);
        return this.todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = getTodo(id);

        this.todoRepository.delete(todo);
    }

    @Transactional
    public Todo updateTodo(Long id, TodoDto todoDto) {
        Todo existTodo = getTodo(id);

        existTodo.updateTodo(todoDto);

        return existTodo;
    }
}
