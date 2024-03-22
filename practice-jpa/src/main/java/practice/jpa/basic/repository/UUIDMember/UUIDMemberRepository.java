package practice.jpa.basic.repository.UUIDMember;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import practice.jpa.basic.entity.uuid.UUIDMember;

public interface UUIDMemberRepository extends CrudRepository<UUIDMember, UUID> {

    Optional<UUIDMember> findByName(String name);
}
