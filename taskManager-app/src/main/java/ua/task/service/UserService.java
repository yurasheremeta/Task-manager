package ua.task.service;

import java.util.List;

import ua.task.domain.UserDTO;


public interface UserService {

	void save(UserDTO dto);
	
	List<UserDTO> findAllUsers();
	
	UserDTO findById(Long id);
	
	void upate(UserDTO dto);
	
	void delete(Long id);
	
	//UserDTO findByUsername(String username);
	
	
}
