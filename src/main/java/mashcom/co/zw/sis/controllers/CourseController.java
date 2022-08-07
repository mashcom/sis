package mashcom.co.zw.sis.controllers;
import mashcom.co.zw.sis.models.Course;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.services.CourseService;
import mashcom.co.zw.sis.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Period> saveCourse(@RequestBody Course course) {
        Course response = courseService.saveNewCourse(course);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
