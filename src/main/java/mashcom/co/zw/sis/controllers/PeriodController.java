package mashcom.co.zw.sis.controllers;

import mashcom.co.zw.sis.models.ActivePeriodRegistration;
import mashcom.co.zw.sis.models.ActivePeriodResults;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/period")
@CrossOrigin(allowedHeaders = "*")
public class PeriodController {

    @Autowired
    PeriodService periodService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Period> savePeriod(@RequestBody Period period) {
        Period response = periodService.savePeriod(period);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * Create a new active results period
     *
     * @param period
     * @return
     */
    @PostMapping(value = "result", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActivePeriodResults> saveResultsPeriod(@RequestBody ActivePeriodResults period) {
        ActivePeriodResults response = periodService.saveResultsPeriod(period);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "result", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> deleteResultsPeriod(@RequestBody ActivePeriodResults period) {
        Boolean response = periodService.deleteResultsPeriod(period);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    /**
     * Create a new active registrations period
     *
     * @param period
     * @return
     */
    @PostMapping(value = "registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActivePeriodRegistration> saveResultsPeriod(@RequestBody ActivePeriodRegistration period) {
        ActivePeriodRegistration response = periodService.saveRegistrationPeriod(period);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> deleteResultsPeriod(@RequestBody ActivePeriodRegistration period) {
        Boolean response = periodService.deleteRegistrationPeriod(period);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
