package practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.query.MemberQuery;
import practice.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberQuery memberQuery;
    @GetMapping("/createMember")
    public void createMember() {
        memberService.joinMember();
    }
    
    
}
