package ua.task.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInRequest {
	private String username;
    private String password;


}
