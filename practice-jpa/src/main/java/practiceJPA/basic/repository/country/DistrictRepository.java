package practiceJPA.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practiceJPA.basic.entity.country.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

}
