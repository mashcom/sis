package mashcom.co.zw.sis.repositories;

import mashcom.co.zw.sis.models.Role;
import mashcom.co.zw.sis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPersonId(Integer personId);

}
