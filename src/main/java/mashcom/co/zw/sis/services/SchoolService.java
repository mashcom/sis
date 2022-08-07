package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.School;
import mashcom.co.zw.sis.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

}
