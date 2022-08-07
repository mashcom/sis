package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Student;
import mashcom.co.zw.sis.models.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentParent, Integer> {

    @Query(value = "SELECT * FROM student WHERE personId=?", nativeQuery = true)
    Optional<Student> getByPersonId(Integer personId);
}
