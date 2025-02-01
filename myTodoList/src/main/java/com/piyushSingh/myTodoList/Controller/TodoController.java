package com.piyushSingh.myTodoList.Controller;

import com.piyushSingh.myTodoList.Entity.Todo;
import com.piyushSingh.myTodoList.Service.AsyncService;
import com.piyushSingh.myTodoList.Service.TodoService;
import com.piyushSingh.myTodoList.config.TodoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "https://localhost:5173")
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodo(){
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
        Todo newOne = todoService.addTodo(todo);
        return new ResponseEntity<>(newOne, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        if (updatedTodo != null) {
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean isDeleted = todoService.deleteTodo(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    private TodoClient todoClient;

    @GetMapping("/all")
    public ResponseEntity<?> fetchTodo() {
        try {
            List<Todo> todos = todoClient.getTodos();
            return ResponseEntity.ok(todos);
        } catch (Exception e) {
            // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching todos");
        }
    }

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/thread")
    public CompletableFuture<List<Todo>> getTodoThread(){
        return asyncService.gotTodo();
    }

}
