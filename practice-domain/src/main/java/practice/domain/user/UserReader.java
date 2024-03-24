package practice.domain.user;

import org.springframework.stereotype.Component;

@Component
public class UserReader {

    private UserRepository userRepository;

    public User read(Long id) {
        return userRepository.read(id);
    }
}
