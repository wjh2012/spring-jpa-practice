package practice.jpa.service;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.entity.member.Member;
import practice.jpa.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void joinMember() {
        Member member = new Member();
        member.setName("member1");
        memberRepository.save(member);
    }
}
