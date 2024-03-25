package practice.app.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.domain.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String name;

    public static UserResponse of(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.name = user.getName();
        return userResponse;
    }
}
