package ua.task.service;

import java.util.List;


import ua.task.domain.TaskDTO;

public interface TaskService {
	
	void save(TaskDTO dto);
	
	List<TaskDTO> findAllTasks ();
	
	TaskDTO findById(Long id);
	
	void updateTask(TaskDTO dto);
	
	void deleteTask(Long id);

}
