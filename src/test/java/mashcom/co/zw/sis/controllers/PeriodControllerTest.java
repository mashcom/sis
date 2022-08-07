package mashcom.co.zw.sis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mashcom.co.zw.sis.models.ActivePeriodRegistration;
import mashcom.co.zw.sis.models.ActivePeriodResults;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.models.School;
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
public class PeriodControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldSaveNewPeriod() throws Exception {

        Faker faker = new Faker();

        Period period  = new Period();
        period.setName("TERM 1 2022");
        period.setSchoolId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(period);

        this.mockMvc.perform(post("/api/v1/period")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveNewRegistrationPeriod() throws Exception {

        Faker faker = new Faker();

        ActivePeriodRegistration period = new ActivePeriodRegistration();
        period.setPeriodId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(period);

        this.mockMvc.perform(post("/api/v1/period/registration")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteRegistrationPeriod() throws Exception {

        Faker faker = new Faker();

        ActivePeriodRegistration period = new ActivePeriodRegistration();
        period.setPeriodId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(period);

        this.mockMvc.perform(delete("/api/v1/period/registration")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveNewResultsPeriod() throws Exception {

        Faker faker = new Faker();

        ActivePeriodResults period = new ActivePeriodResults();
        period.setPeriodId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(period);

        this.mockMvc.perform(post("/api/v1/period/result")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteResultsPeriod() throws Exception {

        Faker faker = new Faker();

        ActivePeriodResults period = new ActivePeriodResults();
        period.setPeriodId(1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(period);

        this.mockMvc.perform(post("/api/v1/period/result")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}