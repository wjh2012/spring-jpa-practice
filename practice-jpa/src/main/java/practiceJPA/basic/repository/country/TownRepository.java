package practiceJPA.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practiceJPA.basic.entity.country.Town;

public interface TownRepository extends CrudRepository<Town, Long> {

}
