package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentParentRepository extends JpaRepository<StudentParent, Integer> {

    @Query(value = "SELECT * FROM student_parent WHERE parentId=? AND personId=? LIMIT 1", nativeQuery = true)
    Optional<StudentParent> findStudentParentByIds(Integer parentId, Integer personId);


}
