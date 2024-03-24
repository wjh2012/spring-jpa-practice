package practice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReader userReader;
    private final UserWriter userWriter;

    public Long add(String name) {
        return userWriter.add(name);
    }

    public User read(Long id) {
        return userReader.read(id);
    }

}
