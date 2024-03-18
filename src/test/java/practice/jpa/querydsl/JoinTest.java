package practice.jpa.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.mapping.oneway.ManyToOne.Oneway_Member_Master;
import practice.jpa.mapping.oneway.ManyToOne.QOneway_Member_Master;
import practice.jpa.mapping.oneway.ManyToOne.QOneway_Team_Slave;
import practice.jpa.mapping.twoway.ManyToOne.Twoway_Member_Master;
import practice.jpa.mapping.twoway.ManyToOne.Twoway_Team_Slave;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static practice.jpa.basic.entity.member.QMember.member;

@DisplayName("조인 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JoinTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    void queryDSL_조인_테스트() {

        // given
        Twoway_Team_Slave team1 = new Twoway_Team_Slave();
        team1.setName("team_name1");

        Twoway_Member_Master member1 = new Twoway_Member_Master();
        member1.setName("member1_name");
        Twoway_Member_Master member2 = new Twoway_Member_Master();
        member2.setName("member2_name");

        member1.setTeam(team1);
        member2.setTeam(team1);

        em.persist(team1);
        em.persist(member1);
        em.persist(member2);

        em.flush();
        em.clear();

        // when
        JPAQueryFactory query = new JPAQueryFactory(em);

        QOneway_Member_Master member = QOneway_Member_Master.oneway_Member_Master;
        QOneway_Team_Slave team = QOneway_Team_Slave.oneway_Team_Slave;

        List<Oneway_Member_Master> fetch = query
                .select(member)
                .from(member)
                .join(member.team, team)
                .fetch();

        // then
        fetch.forEach(m -> Assertions.assertThat(m.getTeam()).isNotNull());
    }


}
