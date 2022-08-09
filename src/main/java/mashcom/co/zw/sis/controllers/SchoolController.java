package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.models.School;
import mashcom.co.zw.sis.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school")
@CrossOrigin(allowedHeaders = "*")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<School> saveSchool(@RequestBody School school) {
        School response = schoolService.saveSchool(school);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
