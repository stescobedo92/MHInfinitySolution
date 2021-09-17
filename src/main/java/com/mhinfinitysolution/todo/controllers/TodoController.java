package com.mhinfinitysolution.todo.controllers;

import com.mhinfinitysolution.todo.model.Todo;
import com.mhinfinitysolution.todo.services.ITodoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Contacts.",tags = {"Todo"})
@RestController
@RequestMapping("todo")
public class TodoController {
    private final ITodoService _todoService;

    @Autowired
    public TodoController(ITodoService todoService) {
        _todoService = todoService;
    }

    @GetMapping()
    public List<Todo> getTodoList() {
        return _todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") int id) {
        Todo todo = _todoService.getTodo(id);
        return todo != null ? new ResponseEntity<>(todo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> storeTodo(@RequestBody Todo todo) {
        return _todoService.saveTodo(todo) != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> saveTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        Todo exTodo = _todoService.getTodo(id);
        todo.setId(id);
        return exTodo != null ? _todoService.saveTodo(todo) != null
                ? new ResponseEntity<>("Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) {
        Todo exTodo = _todoService.getTodo(id);
        return exTodo != null ? _todoService.deleteTodo(id)
                ? new ResponseEntity<>("Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
