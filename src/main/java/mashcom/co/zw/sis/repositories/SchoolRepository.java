package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
