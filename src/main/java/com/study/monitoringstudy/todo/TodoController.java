package com.study.monitoringstudy.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // todo 리스트 전체 조회
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    // todo 생성
    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoRequest request) {
        return ResponseEntity.ok(todoService.create(request));
    }

    // todo 수정
    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long todoId,
            @RequestBody TodoRequest request

    ) {
        return ResponseEntity.ok(todoService.update(todoId, request));
    }

}
