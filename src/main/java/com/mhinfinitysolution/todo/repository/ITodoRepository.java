package com.mhinfinitysolution.todo.repository;

import com.mhinfinitysolution.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<Todo,Integer> {
}
