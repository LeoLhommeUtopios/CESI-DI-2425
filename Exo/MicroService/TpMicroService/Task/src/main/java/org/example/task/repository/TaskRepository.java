package org.example.task.repository;

import org.example.task.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
    List<Task> findTaskByIdUser(int idUser);
}
