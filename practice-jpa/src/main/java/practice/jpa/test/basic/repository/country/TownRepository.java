package practice.jpa.test.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.country.Town;

public interface TownRepository extends CrudRepository<Town, Long> {

}
