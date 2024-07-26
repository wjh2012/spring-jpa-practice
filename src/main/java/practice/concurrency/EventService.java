package practice.concurrency;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final MemberRepository memberRepository;

    @Transactional
    public void memberJoinEvent(RequestDto requestDto) {
        List<MemberEntity> members = memberRepository.findAll();

        // 선착순 30명
        if (members.size() >= 30) {
            return ;
        }
        memberRepository.save(requestDto.toModel());
    }
}
