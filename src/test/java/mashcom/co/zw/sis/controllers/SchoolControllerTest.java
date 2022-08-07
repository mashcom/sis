package mashcom.co.zw.sis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mashcom.co.zw.sis.models.School;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SchoolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveNewSchool() throws Exception {

        Faker faker = new Faker();

        School school = new School();
        school.setName(faker.name().name());
        school.setAddress(faker.address().fullAddress());
        school.setCity(faker.address().cityName());
        school.setCountry(faker.address().country());
        school.setEmail(faker.internet().emailAddress());
        school.setPhoneNumber(faker.phoneNumber().cellPhone());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(school);

        this.mockMvc.perform(post("/api/v1/school")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}