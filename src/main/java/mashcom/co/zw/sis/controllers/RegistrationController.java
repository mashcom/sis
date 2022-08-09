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
@CrossOrigin(allowedHeaders = "*")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    /**
     * @param onActive
     * @return
     * @// TODO: 8/7/2022 implement method
     */

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Registration> getAllRegistration(Boolean onActive) {
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Registration> registerStudent(@RequestBody Registration registration) {
        var response = registrationService.registerStudent(registration);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Registration> deregisterStudent(@PathVariable Integer id) {
        var registation = registrationService.findById(id);
        System.out.println(registation);
        if (registation.isEmpty()) {
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        }
        var response = registrationService.deregisterStudent(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
