package com.mhinfinitysolution.todo.services;

import com.mhinfinitysolution.todo.model.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> getTodoList();
    Todo getTodo(int todo);
    Todo saveTodo(Todo todo);
    boolean deleteTodo(int id);
}
