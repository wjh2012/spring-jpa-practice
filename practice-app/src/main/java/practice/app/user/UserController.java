package practice.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.domain.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}")
    public UserResponse findUser(@PathVariable Long userId) {
        return UserResponse.of(userService.read(userId));
    }

    @PostMapping("/users")
    public NewUserResponse addUser(@RequestBody NewUserRequest request) {
        return new NewUserResponse(userService.add(request.getName()));
    }
}
