package practice.jpa.repository.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.jpa.entity.member.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>, MemberRepositoryCustom {

}
