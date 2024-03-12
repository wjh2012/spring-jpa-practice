package practice.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.jpa.entity.uuid.UUIDMember;
import practice.jpa.repository.UUIDMember.UUIDMemberRepository;

@DisplayName("UUID 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
public class UUIDTest {

    @Autowired
    UUIDMemberRepository uuidMemberRepository;

    @Test
    void UUID_생성_테스트(){
        UUIDMember UUIDMember = new UUIDMember();
        uuidMemberRepository.save(UUIDMember);
    }
}
