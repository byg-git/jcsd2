package bi.com.controller;

import bi.com.entity.Admin;
import bi.com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource(name = "adminServiceImpl")
    @Autowired

    private AdminService adminService;


    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/list")
    @ResponseBody
    public void slist(HttpServletResponse response) throws IOException {

//        Map map = new HashMap<>();
//        List<Admin> adminList = adminService.selectAll();
//        map.put("total",adminList.size());
//        map.put("rows",adminList);
//        response.getWriter().println(map);
        response.getWriter().println("{\"total\":3,\"rows\":[");
        response.getWriter().println("{\"id\":\"FI-SW-01\",\"name\":\"Koi1\",\"pass\":10.001},");
        response.getWriter().println("{\"id\":\"FI-SW-02\",\"name\":\"Koi2\",\"pass\":10.002},");
        response.getWriter().println("{\"id\":\"FI-SW-03\",\"name\":\"Koi3\",\"pass\":10.003},");
        response.getWriter().println("]}");
    }
}
