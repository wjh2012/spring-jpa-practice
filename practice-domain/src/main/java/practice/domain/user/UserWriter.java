package practice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserWriter {

    private final UserRepository userRepository;

    public Long add(String name) {
        return userRepository.add(name);
    }
}
