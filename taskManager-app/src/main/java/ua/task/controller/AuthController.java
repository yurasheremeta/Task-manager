package ua.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.task.domain.UserDTO;
import ua.task.domain.request.SignInRequest;
import ua.task.domain.responce.SignInResponce;
import ua.task.service.UserService;
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<Void> registerUser(@RequestBody UserDTO dto){
		userService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<SignInResponce> signin(@RequestBody SignInRequest request){
		String token = userService.signin(request.getUsername(), request.getPassword());
		String role = "";
		
		if(token != null) {
			role  = userService.findByUsername(request.getUsername()).getRole().toString();
		}
		return new ResponseEntity<SignInResponce>(new SignInResponce(token,role) , HttpStatus.OK);
	}

}
