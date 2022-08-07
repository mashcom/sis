package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Course;
import mashcom.co.zw.sis.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
