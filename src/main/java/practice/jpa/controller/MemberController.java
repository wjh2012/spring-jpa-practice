package practice.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.jpa.query.MemberQuery;
import practice.jpa.service.MemberService;

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
