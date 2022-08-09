package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.enums.PersonType;
import mashcom.co.zw.sis.exceptions.StudentNotFoundException;
import mashcom.co.zw.sis.http.Response;
import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.models.StudentParent;
import mashcom.co.zw.sis.services.PersonService;
import mashcom.co.zw.sis.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(allowedHeaders = "*")
public class StudentController {

    @Autowired
    PersonService personService;

    @Autowired
    StudentService studentService;


    /**
     * Get all students for a school
     *
     * @return
     */
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getAllStudents() {
        Optional<Collection<Map>> students = studentService.getAllStudents(Integer.valueOf(1));
        return new ResponseEntity(students, HttpStatus.OK);
    }

    /**
     * Create new student details
     *
     * @param person
     * @return
     */
    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> saveStudent(@RequestBody Person person) {
        Person response = personService.savePerson(person, PersonType.STUDENT);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * Get single student details
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> show(@PathVariable("id") Integer id) throws StudentNotFoundException {
        Optional<Person> response = personService.findById(id);
        if (response.isEmpty()) throw new StudentNotFoundException();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * Assign student to parent/guardian
     *
     * @param studentParent
     * @return
     */
    @PostMapping(value = "/parent", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StudentParent> addStudentParentRelationship(@RequestBody StudentParent studentParent) {
        StudentParent response = studentService.assignParent(studentParent);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    /**
     * Remove relationship between student and parent
     *
     * @param studentParent
     * @return
     */
    @DeleteMapping(value = "/parent", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StudentParent> removeStudentParentRelationship(@RequestBody StudentParent studentParent) {

        Boolean hasRemovedRelationship = studentService.removeParent(studentParent.getParentId(), studentParent.getPersonId());

        Map<String, String> response = (hasRemovedRelationship) ? Response.success("Request completed successfully!") : Response.error("Request could not be completed");
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
