package practice.jpa.test.basic.repository.UUIDMember;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.uuid.UUIDMember;

public interface UUIDMemberRepository extends CrudRepository<UUIDMember, UUID> {

    Optional<UUIDMember> findByName(String name);
}
