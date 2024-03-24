package practice.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import practice.domain.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
