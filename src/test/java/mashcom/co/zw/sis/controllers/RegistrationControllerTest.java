package mashcom.co.zw.sis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mashcom.co.zw.sis.models.Registration;
import mashcom.co.zw.sis.repositories.RegistrationRepository;
import mashcom.co.zw.sis.services.RegistrationService;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    RegistrationService registrationService;

    @Test
    public void shouldRegisterStudent() throws Exception {

        Faker faker = new Faker();

        Registration registration = new Registration();
        registration.setPeriodId(1);
        registration.setStudentId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(registration);

        this.mockMvc.perform(post("/api/v1/registration")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeregisterStudent() throws Exception {

        var registration = registrationService.findById(1);
        var response = registration.isPresent()?status().isOk():status().isNotFound();
        this.mockMvc.perform(delete("/api/v1/registration/1"))
                .andDo(print())
                .andExpect(response);
    }

}