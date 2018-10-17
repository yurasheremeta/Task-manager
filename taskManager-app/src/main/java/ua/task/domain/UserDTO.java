package ua.task.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
	
	private Long id;
	
private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private	Date dayOfBirth;
	
	private List<TaskDTO> tasks;
	

}
