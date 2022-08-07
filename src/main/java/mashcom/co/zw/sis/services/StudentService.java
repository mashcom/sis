package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.models.StudentParent;
import mashcom.co.zw.sis.repositories.PersonRepository;
import mashcom.co.zw.sis.repositories.StudentParentRepository;
import mashcom.co.zw.sis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentParentRepository studentParentRepository;

    public StudentParent assignParent(StudentParent studentParent) {
        return studentRepository.save(studentParent);
    }

    public boolean removeParent(Integer parentId, Integer personId) {
        Optional<Person> parent = personRepository.findById(parentId);
        if (parent.isPresent() == false) return false;

        Optional<Person> student = personRepository.findById(personId);
        if (student.isPresent() == false) return false;

        Optional<StudentParent> studentParent = studentParentRepository.findStudentParentByIds(parent.get().getId(), student.get().getId());

        if (studentParent.isPresent() == false) return false;

        studentParentRepository.deleteById(studentParent.get().getStudentId());
        return studentParentRepository.findById(studentParent.get().getStudentId()).isEmpty();
    }
}
