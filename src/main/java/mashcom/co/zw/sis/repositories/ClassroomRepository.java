package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Classroom;
import mashcom.co.zw.sis.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
