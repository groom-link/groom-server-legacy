package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.Todo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.QTodo.todo;

public class TodoRepositoryCustomImpl implements TodoRepositoryCustom{

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public TodoRepositoryCustomImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Slice<Todo> findAllByUserIdRoomId(Long roomId, Long userInfoId, Pageable pageable) {
        List<Todo> todoList = query.selectFrom(todo)
                .where(todo.userInfo.id.eq(userInfoId).and(todo.room.id.eq(roomId)))
                .fetch();

        boolean hasNext = false;
        if (todoList.size() > pageable.getPageSize()) {
            todoList.remove(pageable.getPageSize());
            hasNext = true;
        }
        return new SliceImpl<>(todoList, pageable, hasNext);
    }


    @Override
    public Slice<Todo> findAllByRoomId(Long roomId, Pageable pageable) {

        List<Todo> todoList = query.selectFrom(todo)
                .where(todo.room.id.eq(roomId))
                .offset(pageable.getOffset())   //N 번부터 시작
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = false;
        if (todoList.size() > pageable.getPageSize()) {
            todoList.remove(pageable.getPageSize());
            hasNext = true;
        }
        return new SliceImpl<>(todoList, pageable, hasNext);
    }
}
