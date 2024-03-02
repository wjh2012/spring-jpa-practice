package practice.jpa.query;

import static practice.jpa.entity.country.QCity.city;
import static practice.jpa.entity.country.QCountry.country;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import practice.jpa.entity.country.City;
import practice.jpa.entity.country.Country;

@Repository
public class CountryQuery {
    @PersistenceContext
    private EntityManager em;

    public void test() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Country> countries = queryFactory
            .select(country)
            .from(country)
            .fetch();

        List<List<City>> collect = countries.stream().map(Country::getCities)
            .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("hello test");
    }

    public void test2() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Country> fetch = queryFactory
            .select(country)
            .from(country)
            .join(country.cities, city)
            .fetch();

        System.out.println("hello test");
    }
}
