package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Exam;
import mashcom.co.zw.sis.models.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {
}
