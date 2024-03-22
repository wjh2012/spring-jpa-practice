package practice.jpa.basic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.basic.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

}
