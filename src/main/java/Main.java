import com.rn.code.service.RestService;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        /*
//        * example for using this service.
//        * */
        Map<String,String> headerParams = new HashMap<String, String>(){{
            put("Content-Type","application/json");
        }};
        String body = "{ \"key\":\"value\" }";
        RestService service = new RestService("https://api.myurl.com:port/samplrUrl", body, headerParams);
        int i = 0;
        while(i < 5){
            Object object = service.makeRequest();
            System.out.println("object = " + object);
            i++;
        }
    }
}
