package practice.jpa.test.basic.repository.member;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.member.Member;

public interface MemberRepository extends CrudRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByName(String name);
}
