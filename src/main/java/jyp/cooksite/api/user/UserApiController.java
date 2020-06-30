package jyp.cooksite.api.user;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jyp.cooksite.domain.user.User;
import jyp.cooksite.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/api/user/join")
	public CreateUserResponse join(@RequestBody @Valid CreateUserRequest request) {
		User user = new User(request.getName(), request.getEmail());

		Long id = userService.join(user);
		return new CreateUserResponse(id);
	}

	@Data
	static class CreateUserRequest {
		private String name;
		private String email;
	}

	@Data
	class CreateUserResponse {
		private Long id;
	
		public CreateUserResponse(Long id) {
			this.id = id;
		}
	}

}
