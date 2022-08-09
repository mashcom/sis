package mashcom.co.zw.sis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mashcom.co.zw.sis.enums.PersonType;
import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.models.StudentParent;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String firstName, lastName, email, phoneNumber, alternativePhoneNumber, password;
    Boolean booleanType;
    String sex;
    Timestamp dob;
    StudentControllerTest() {
        Faker faker = new Faker();

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().cellPhone();
        this.alternativePhoneNumber = faker.phoneNumber().phoneNumber();
        this.password = faker.random().hex();
        this.booleanType = faker.bool().bool();
        this.sex = faker.gender().binaryTypes();
        this.dob = faker.date().birthday();



    }


    @Test
    public void shouldAddStudentWithRequiredFields() throws Exception {


        Person person = new Person();
        person.setFirstNames(firstName);
        person.setSurname(lastName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        person.setAlternativePhoneNumber(alternativePhoneNumber);
        person.setIsActive(booleanType);
        person.setSchoolId(1);
        person.setPassword(password);
        person.setSex(sex);
        person.setDob(dob);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(person);

        System.out.println(requestJson);
        this.mockMvc.perform(post("/api/v1/student")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetListOfStudents() throws Exception {
        this.mockMvc.perform(get("/api/v1/student"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetSingleStudent() throws Exception {
        this.mockMvc.perform(get("/api/v1/student/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotGetSingleStudent() throws Exception {
        this.mockMvc.perform(get("/api/v1/student/19999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldAssignStudentToParent() throws Exception {

        StudentParent studentParent = new StudentParent();
        studentParent.setParentId(1);
        studentParent.setPersonId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(studentParent);


        this.mockMvc.perform(post("/api/v1/student/parent")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRemoveStudentParentRelationship() throws Exception {

        StudentParent studentParent = new StudentParent();
        studentParent.setParentId(1);
        studentParent.setPersonId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(studentParent);


        this.mockMvc.perform(delete("/api/v1/student/parent")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}