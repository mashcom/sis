package mashcom.co.zw.sis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student record could not be found")
public class StudentNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Student record could not be found";
    }
}
