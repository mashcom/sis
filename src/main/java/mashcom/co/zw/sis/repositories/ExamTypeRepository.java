package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, Integer> {
}
