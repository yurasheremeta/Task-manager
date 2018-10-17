package ua.task.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor


public class TaskDTO {
	
	private Long id;

	private String name;
	
	private String description;
	
	private Date date;


}
