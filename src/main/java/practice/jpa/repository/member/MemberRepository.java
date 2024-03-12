package practice.jpa.repository.member;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.jpa.entity.member.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByName(String name);
}
