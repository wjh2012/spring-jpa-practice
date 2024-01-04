package practice.repository.nation;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class NationQuery {

    @PersistenceContext
    private EntityManager em;
    
    public void test() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        
    }
}
