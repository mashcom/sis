package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.models.Registration;
import mashcom.co.zw.sis.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    /**
     * @param onActive
     * @return
     * @// TODO: 8/7/2022 implement method
     */

    public ResponseEntity<Registration> getAllRegistration(Boolean onActive) {
        return new ResponseEntity(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Registration> registerStudent(@RequestBody Registration registration) {
        var response = registrationService.registerStudent(registration);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Registration> deregisterStudent(@RequestBody  Integer id) {
        var response = registrationService.deregisterStudent(id);
        return new ResponseEntity(response, response?HttpStatus.OK:HttpStatus.NOT_ACCEPTABLE);
    }


}
