package bi.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aadmin")
public class AdminindexController {

    @RequestMapping("/index")
    public String inde(){
        return "adminindex";
    }
}
