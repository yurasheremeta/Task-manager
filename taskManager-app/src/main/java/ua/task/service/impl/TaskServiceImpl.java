package ua.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import ua.task.domain.TaskDTO;
import ua.task.entity.TaskEntity;
import ua.task.repository.TaskRepository;
import ua.task.service.TaskService;
import ua.task.utils.ObjectMapperUtils;
@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void save(TaskDTO dto) {
		TaskEntity entity = modelMapper.map(dto, TaskEntity.class);
		taskRepository.save(entity);
		
		
	}

	@Override
	public List<TaskDTO> findAllTasks() {
		List<TaskEntity> entity = taskRepository.findAll();
		List<TaskDTO> dto = modelMapper.mapAll(entity, TaskDTO.class);
		return dto;
	}

	@Override
	public void updateTask(TaskDTO dto) {
		taskRepository.save(modelMapper.map(dto, TaskEntity.class));
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public TaskDTO findById(Long id) {
		TaskEntity entity = taskRepository.findById(id).get();
		return modelMapper.map(entity, TaskDTO.class);
	}
	
	

}
