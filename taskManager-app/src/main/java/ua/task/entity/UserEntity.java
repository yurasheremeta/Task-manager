package ua.task.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private	Date dayOfBirth;

}
