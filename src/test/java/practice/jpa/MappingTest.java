package practice.jpa;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.mapping.oneway.ManyToOne.Oneway_Member_Master;
import practice.jpa.mapping.oneway.ManyToOne.Oneway_Team_Slave;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DisplayName("JPA 연관관계 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
public class MappingTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void 단방향_일대다() {
        Oneway_Member_Master member = new Oneway_Member_Master();
        Oneway_Team_Slave team = new Oneway_Team_Slave();

        em.persist(member);
        em.persist(team);
    }

    @Test
    void 단방향_다대일() {

    }

    @Test
    void 양방향_일대다() {

    }

    @Test
    void 양방향_다대일() {

    }
}
