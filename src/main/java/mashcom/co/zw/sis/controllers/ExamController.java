package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.models.Exam;
import mashcom.co.zw.sis.models.ExamResult;
import mashcom.co.zw.sis.models.ExamType;
import mashcom.co.zw.sis.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exam")
@CrossOrigin(allowedHeaders = "*")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Exam> saveExam(@RequestBody Exam exam) {
        Exam response = examService.saveExam(exam);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "type", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamType> saveExamType(@RequestBody ExamType examType) {
        ExamType response = examService.saveExamType(examType);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "result", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamResult> saveExamType(@RequestBody ExamResult examResult) {
        ExamResult response = examService.saveExamResult(examResult);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
