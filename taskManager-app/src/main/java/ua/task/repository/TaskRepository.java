package ua.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.task.entity.TaskEntity;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
