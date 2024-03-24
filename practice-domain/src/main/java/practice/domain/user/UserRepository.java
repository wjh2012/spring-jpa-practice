package practice.domain.user;

public interface UserRepository {

    public Long add(String name);

    public User read(Long id);
}
