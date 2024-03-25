package practice.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.domain.user.User;
import practice.domain.user.UserRepository;

@Repository
@RequiredArgsConstructor
class UserEntityRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Long add(String name) {
        UserEntity userEntity = new UserEntity();
        return userJpaRepository.save(userEntity).getId();
    }

    @Override
    public User read(Long id) {
        UserEntity userEntity = userJpaRepository.findById(id).orElseThrow();
        return User.builder().id(userEntity.getId()).name(userEntity.getName()).build();
    }
}
