package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT * FROM person WHERE schoolId=?", nativeQuery = true)
    Optional<Collection<Map>> getAll(Integer schoolId);

    Person findByEmail(String email);


}
