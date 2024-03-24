package practice.domain.user;

import org.springframework.stereotype.Component;

@Component
public class UserWriter {

    private UserRepository userRepository;

    public Long add(String name) {
        return userRepository.add(name);
    }
}
