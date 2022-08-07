package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Optional<Collection<Map>> getAllStudents(Integer schoolId) {
        return personRepository.getAll(schoolId);
    }

    public Person saveStudent(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }
}
