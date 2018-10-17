package ua.task.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.task.domain.TaskDTO;
import ua.task.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	@PostMapping
	public ResponseEntity<Void> createTask(@RequestBody TaskDTO dto){
		taskService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<TaskDTO>> GetAllTasks(){
		List<TaskDTO> dto = taskService.findAllTasks();
		return new ResponseEntity<List<TaskDTO>>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{taskId}")
	public ResponseEntity<Void> update(@PathVariable("taskId") Long id , @RequestBody TaskDTO dto){
		TaskDTO dtoFromDB = taskService.findById(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			taskService.updateTask(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/delete/{taskId}")
	public ResponseEntity<TaskDTO> deleteTaskById(@PathVariable("taskId") Long id){
		TaskDTO dto = taskService.findById(id);
		if(dto != null) {
			taskService.deleteTask(id);
			return new ResponseEntity<TaskDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<TaskDTO>(dto , HttpStatus.NOT_FOUND);
	}

}
