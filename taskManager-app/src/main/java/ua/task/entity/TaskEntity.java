package ua.task.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity{
	
	private String name;
	
	private String description;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
