package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Registration;
import mashcom.co.zw.sis.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public Registration registerStudent(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Boolean deregisterStudent(Integer id) {
        registrationRepository.deleteById(id);
        return registrationRepository.findById(id).isEmpty();
    }

}
