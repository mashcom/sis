package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Classroom;
import mashcom.co.zw.sis.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public Optional<Classroom> findById(Integer id){
        return classroomRepository.findById(id);
    }

    public Classroom saveNewClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }


}
