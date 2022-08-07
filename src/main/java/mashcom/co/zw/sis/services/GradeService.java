package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Grade;
import mashcom.co.zw.sis.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public Optional<Grade> findById(Integer id){
        return gradeRepository.findById(id);
    }

    public Grade saveNewGrade(Grade grade){
        return gradeRepository.save(grade);
    }


}
