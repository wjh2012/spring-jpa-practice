package practice.jpa.mappingTest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.mapping.twoway.ManyToOne.Twoway_Member_Master;
import practice.jpa.mapping.twoway.ManyToOne.Twoway_Team_Slave;
import practice.jpa.mapping.twoway.OneToMany.Twoway_Member_Slave;
import practice.jpa.mapping.twoway.OneToMany.Twoway_Team_Master;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DisplayName("양방향 연관관계 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TwowayMappingTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    @Order(1)
    void many_주인_INSERT() {
        // given
        Twoway_Team_Slave team1 = new Twoway_Team_Slave();
        team1.setName("team_name1");
        Twoway_Team_Slave team2 = new Twoway_Team_Slave();
        team2.setName("team_name2");

        Twoway_Member_Master member1 = new Twoway_Member_Master();
        team1.setName("member1_name");
        Twoway_Member_Master member2 = new Twoway_Member_Master();
        team1.setName("member2_name");
        Twoway_Member_Master member3 = new Twoway_Member_Master();
        team1.setName("member3_name");
        // when
        member1.setTeam(team1);
        member2.setTeam(team1);
        member3.setTeam(team1);

        em.persist(team1);
        em.persist(team2);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
    }

    @Test
    @Order(2)
    void one_주인_INSERT() {
        // given
        Twoway_Team_Master team1 = new Twoway_Team_Master();
        team1.setName("team_name1");
        Twoway_Team_Master team2 = new Twoway_Team_Master();
        team2.setName("team_name2");

        Twoway_Member_Slave member1 = new Twoway_Member_Slave();
        team1.setName("member1_name");
        Twoway_Member_Slave member2 = new Twoway_Member_Slave();
        team1.setName("member2_name");
        Twoway_Member_Slave member3 = new Twoway_Member_Slave();
        team1.setName("member3_name");

        // when
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);
        team1.getMembers().add(member3);

        em.persist(team1);
        em.persist(team2);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
    }

    @Test
    @Order(3)
    void many_주인_SELECT() {
        em.find(Twoway_Team_Slave.class, 1L);

        em.find(Twoway_Member_Master.class, 1L);
        em.find(Twoway_Member_Master.class, 2L);
        em.find(Twoway_Member_Master.class, 3L);
    }

    @Test
    @Order(4)
    void one_주인_SELECT() {
        em.find(Twoway_Team_Master.class, 1L);

        em.find(Twoway_Member_Slave.class, 1L);
        em.find(Twoway_Member_Slave.class, 2L);
        em.find(Twoway_Member_Slave.class, 3L);
    }

    @Test
    @Order(5)
    void many_주인_team_UPDATE() {
        Twoway_Team_Slave team = em.find(Twoway_Team_Slave.class, 1L);

        em.find(Twoway_Member_Master.class, 1L);
        em.find(Twoway_Member_Master.class, 2L);
        em.find(Twoway_Member_Master.class, 3L);

        team.setName("updated");
    }

    @Test
    @Order(6)
    void one_주인_team_UPDATE() {
        Twoway_Team_Master team = em.find(Twoway_Team_Master.class, 1L);

        em.find(Twoway_Member_Slave.class, 1L);
        em.find(Twoway_Member_Slave.class, 2L);
        em.find(Twoway_Member_Slave.class, 3L);

        team.setName("updated");
    }
}
