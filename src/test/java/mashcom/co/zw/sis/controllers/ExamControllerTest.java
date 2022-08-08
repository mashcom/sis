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

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldSaveNewExamType() throws Exception {

        Faker faker = new Faker();

        ExamType examType = new ExamType();
        examType.setName(faker.funnyName().name());
        examType.setDescription(faker.funnyName().name());


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(examType);

        this.mockMvc.perform(post("/api/v1/exam/type")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveNewExam() throws Exception {

        Faker faker = new Faker();

        Exam exam = new Exam();
        exam.setName(faker.funnyName().name());
        exam.setExamTypeId(1);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(exam);

        this.mockMvc.perform(post("/api/v1/exam")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldSaveNewExamResult() throws Exception {

        Faker faker = new Faker();

        Integer mark = faker.number().numberBetween(1,100);
        ExamResult examResult = new ExamResult();
        examResult.setExamId(1);
        examResult.setCourseId(1);
        examResult.setMark(mark.toString());
        examResult.setStudentId(1);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(examResult);

        this.mockMvc.perform(post("/api/v1/exam/result")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


}