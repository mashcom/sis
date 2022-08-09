package mashcom.co.zw.sis.controllers;
import mashcom.co.zw.sis.models.Classroom;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.services.ClassroomService;
import mashcom.co.zw.sis.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/classroom")
@CrossOrigin(allowedHeaders = "*")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Period> saveClassroom(@RequestBody Classroom classroom) {
        Classroom response = classroomService.saveNewClassroom(classroom);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
