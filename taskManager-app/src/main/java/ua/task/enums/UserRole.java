package ua.task.enums;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public enum UserRole implements GrantedAuthority {
	ROLE_USER;

	@Override
	public String getAuthority() {
	
		return name();
	}
	
	

}
