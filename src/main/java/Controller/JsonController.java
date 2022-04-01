package Controller;

import entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JsonController {

    @RequestMapping("js1.do")
    public void js1(@RequestBody user u) {
        System.out.println(u);
    }

    @RequestMapping("js2.do")
    @ResponseBody
    public Map<Integer, String> js2() {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"sb");
        map.put(2,"s");
        return map;
    }

}
