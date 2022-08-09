package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.models.Exam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(allowedHeaders = "*")
public class AuthenticationController {

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Exam> authenticate() {

        var response = new HashMap<String,String>();
        response.put("sessionid","1");
        response.put("token","dueyrueyre");


        return new ResponseEntity(response, HttpStatus.OK);
    }
}
