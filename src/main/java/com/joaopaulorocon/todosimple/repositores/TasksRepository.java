package com.joaopaulorocon.todosimple.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaopaulorocon.todosimple.models.Task;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser_Id(Long id);
}
