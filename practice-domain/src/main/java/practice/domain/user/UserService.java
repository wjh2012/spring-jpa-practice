package practice.domain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserReader userReader;
    private UserWriter userWriter;

    public Long add(String name) {
        return userWriter.add(name);
    }

    public User read(Long id) {
        return userReader.read(id);
    }

}
