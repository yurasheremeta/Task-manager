package ua.task.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.task.enums.UserRole;

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
	
	@OneToMany(mappedBy = "user")
	private List<TaskEntity> news;
	@Enumerated(EnumType.STRING)
	  private UserRole role;

}
