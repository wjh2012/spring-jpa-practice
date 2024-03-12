package practice.jpa.repository.UUIDMember;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.jpa.entity.uuid.UUIDMember;

public interface UUIDMemberRepository extends CrudRepository<UUIDMember, UUID> {

}
