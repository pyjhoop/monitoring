package com.study.monitoringstudy.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Transactional
    public Todo create(TodoRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getDescription());
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo update(Long todoId, TodoRequest request) {
        Todo existTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException(todoId+" not found"));

        existTodo.update(request.getTitle(), request.getDescription());
        return existTodo;
    }
}
