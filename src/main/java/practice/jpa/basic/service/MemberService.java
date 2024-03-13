package practice.jpa.basic.service;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.basic.repository.member.MemberRepository;
import practice.jpa.basic.entity.member.Member;

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
