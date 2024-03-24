package practice.jpa.test.basic.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.test.basic.entity.member.Member;
import practice.jpa.test.basic.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDTO getMemberDTO() {
        Optional<Member> byId = memberRepository.findById(1L);
        String name = byId.orElseThrow().getName();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        return memberDTO;
    }
}
