package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class restClientController {
    @Resource
    private RestTemplate restTemplate;
    public static String baseUrl="http://localhost:8080";
}
