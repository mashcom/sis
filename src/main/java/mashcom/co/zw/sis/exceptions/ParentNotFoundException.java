package mashcom.co.zw.sis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Parent record could not be found")
public class ParentNotFoundException extends RuntimeException {
}
