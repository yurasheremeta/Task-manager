package ua.task.controller;

import java.util.List;

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

import ua.task.domain.UserDTO;
import ua.task.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UserDTO dto){
		userService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> dto = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable("userId") Long id , @RequestBody UserDTO dto){
		UserDTO dtoFromDB = userService.findById(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			userService.save(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable("userId") Long id){
		UserDTO dto = userService.findById(id);
		if(dto!=null) {
			userService.delete(id);
			return new ResponseEntity<UserDTO>(dto , HttpStatus.OK);
		}
		return new  ResponseEntity<UserDTO>(dto , HttpStatus.NOT_FOUND);
	}

}
