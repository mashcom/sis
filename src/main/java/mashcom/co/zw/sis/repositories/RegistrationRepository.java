package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {


}
