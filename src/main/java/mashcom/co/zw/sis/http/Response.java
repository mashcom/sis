package mashcom.co.zw.sis.http;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static Map<String, String> success(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("success", "true");
        response.put("message", message);
        return response;
    }

    public static Map<String, String> error(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("success", "false");
        response.put("message", message);
        return response;
    }
}
