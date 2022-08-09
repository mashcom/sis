package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.enums.PersonType;
import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.models.Student;
import mashcom.co.zw.sis.repositories.PersonRepository;
import mashcom.co.zw.sis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;


    public Optional<Collection<Map>> getAllStudents(Integer schoolId) {

        return personRepository.getAll(schoolId);
    }

    public Person savePerson(Person person, PersonType personType) {
        Person newPerson = personRepository.save(person);
        if (personType.equals(PersonType.STUDENT)) {
            Student student = new Student();
            student.setPersonId(newPerson.getId());
            studentRepository.save(student);
        }
        return newPerson;
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }
}
