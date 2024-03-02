package practice.jpa.repository.Umember;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.uuid.Umember;

public interface UmemberRepository extends CrudRepository<Umember, UUID> {

}
