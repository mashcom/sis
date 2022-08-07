package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {


}
