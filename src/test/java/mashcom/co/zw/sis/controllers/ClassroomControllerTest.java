package mashcom.co.zw.sis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mashcom.co.zw.sis.models.*;
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
public class ClassroomControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldSaveNewClassroom() throws Exception {

        Faker faker = new Faker();

        Classroom classroom = new Classroom();
        classroom.setGradeId(1);
        classroom.setPeriodId(1);
        classroom.setStatus("ACTIVE");
        classroom.setTeacherId(1);
        classroom.setCreateAt(faker.date().birthday());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(classroom);

        this.mockMvc.perform(post("/api/v1/classroom")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


}