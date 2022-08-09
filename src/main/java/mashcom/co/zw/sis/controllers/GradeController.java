package mashcom.co.zw.sis.controllers;
import mashcom.co.zw.sis.models.Grade;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.services.GradeService;
import mashcom.co.zw.sis.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grade")
@CrossOrigin(allowedHeaders = "*")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Period> saveGrade(@RequestBody Grade grade) {
        Grade response = gradeService.saveNewGrade(grade);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
