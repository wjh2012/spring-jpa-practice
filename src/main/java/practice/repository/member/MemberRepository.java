package practice.repository.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.entity.member.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>, MemberRepositoryCustom {

}
