package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Student;
import mashcom.co.zw.sis.models.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByPersonId(Integer personId);

    @Query(value = "SELECT * FROM person " +
            "INNER JOIN student ON student.personId=person.id " +
            "WHERE schoolId=? ",
            nativeQuery = true)
    Optional<Collection<Map>> getAll(Integer schoolId);
}
