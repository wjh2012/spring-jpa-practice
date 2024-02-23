package practice.repository.Umember;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import practice.entity.uuid.Umember;

public interface UmemberRepository extends CrudRepository<Umember, UUID> {

}
