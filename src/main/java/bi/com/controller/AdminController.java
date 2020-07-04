package bi.com.controller;

//import bi.com.common.ServerResponse;
//import bi.com.entity.Admin;
//import bi.com.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.DigestUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController{
//
//    @Resource(name = "adminServiceImpl")
//    @Autowired
//
//    private AdminService adminService;
//
//    @RequestMapping("/index")
//    public String adminindex(){
//        return "adminindex";
//    }
//
//    @RequestMapping("/listall")
//    @ResponseBody
//    public Map<String,Object> listall(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        Map<String,Object> map = new HashMap<>();
//        List<Admin> adminList = adminService.selectAll();
//        map.put("total",adminList.size());//这两个都要有，他的数据格式是这样
//        map.put("rows",adminList);
//        System.out.println(adminList.size());
//        System.out.println(map);
//        return map;
//    }
//
//    @RequestMapping("/insertSelective")
//    @ResponseBody
//    public Map<String ,Object> insertSelective(Admin record){
//        Admin admin=new Admin();
//        admin.setName(record.getName());
//        admin.setPass(DigestUtils.md5DigestAsHex(record.getPass().getBytes()));
//        admin.setPhone(record.getPhone());
//        admin.setEmail(record.getEmail());
//        admin.setQq(record.getQq());
//        Map<String,Object> map = new HashMap<>();
//
//        if(admin!= null) {
//            System.out.printf("不等于null");
//            if (adminService.insert(admin) > 0) {
////            return ServerResponse.createBySuccess("添加管理数据成功",admin);
//                map.put("success", 1);
//            } else {
////            return ServerResponse.createByErrorMessage("添加管理员数据失败");
//                map.put("success", 0);
//            }
//        }else{
//            System.out.printf("失败");
//            map.put("success", 0);
//        }
//        return map;
//    }
//}
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import bi.com.common.ResponseCode;
import bi.com.common.ServerResponse;
import bi.com.entity.Admin;
import bi.com.service.AdminService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //这是控制器的的注解，代码当前类为一个控制器
@RequestMapping("/admin")  //这个注解表示控制器的映射的地址为服务器地址+admin
public class AdminController {
    @Resource(name="adminServiceImpl")  //这个注解表示自动注入adminSeerviceImpl业务实现类
    @Autowired      //该注解表示后紧跟的变量进行封装，即自动产生getter和setter

    private AdminService adminService;

    @RequestMapping("/index")
    public String inde(){
        return "adminindex";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id){
        if(adminService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess("删除管理员成功");
        }else{
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Admin record){//管理员的信息应该是由客户端传送过来
        Admin admin=new Admin();
        admin.setName(record.getName());
        admin.setPass(DigestUtils.md5DigestAsHex(record.getPass().getBytes()));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.insert(admin)>0){
            return ServerResponse.createBySuccess("添加数据成功",admin);
        }else{
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Admin record){
        Admin admin=new Admin();
        admin.setName(record.getName());
        admin.setPass(DigestUtils.md5DigestAsHex(record.getPass().getBytes()));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.insert(admin)>0){
            return ServerResponse.createBySuccess("添加管理数据成功",admin);
        }else{
            return ServerResponse.createByErrorMessage("添加管理员数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin=adminService.selectByPrimaryKey(1);
        if(admin != null){
            return ServerResponse.createBySuccess(admin);
        }else{
            return ServerResponse.createByErrorMessage("找不到管理员");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Admin record){
        Admin admin=new Admin();
        admin.setId(record.getId());//更新操作必须要有id主关键字段
        admin.setName(record.getName());
        //采用pring mvc的Digestutils.md5DigestAsHex()方法对密码进行加密
        admin.setPass(DigestUtils.md5DigestAsHex(record.getPass().getBytes()));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.updateByPrimaryKeySelective(admin)>0){
            return ServerResponse.createBySuccess("更新管理数据成功",admin);
        }else{
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Admin record){
        Admin admin=new Admin();
        admin.setId(record.getId());//更新操作必须要有id主关键字段
        admin.setName(record.getName());
        //采用pring mvc的Digestutils.md5DigestAsHex()方法对密码进行加密
        admin.setPass(DigestUtils.md5DigestAsHex(record.getPass().getBytes()));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.updateByPrimaryKeySelective(admin)>0){
            return ServerResponse.createBySuccess("更新管理数据成功",admin);
        }else{
            return ServerResponse.createByErrorMessage("更新管理员数据失败");
        }
    }


    @RequestMapping("/listall")
    @ResponseBody
    public Map<String ,Object> listall(HttpServletRequest request, HttpServletResponse response){
        List<Admin> adminlist=adminService.selectAll();
        Map<String,Object> map = new HashMap<>();
        map.put("total",adminlist.size());
        map.put("rows",adminlist);
        if(adminlist.size()>0){
//            return ServerResponse.createBySuccess(adminlist);
            return map;
        }else{
//            return ServerResponse.createByErrorMessage("找不到管理员信息");
            return map;
        }
    }

    @RequestMapping("/checkAdmin")
    @ResponseBody
    public ServerResponse  checkAdmin(@Param("name") String name){
        if(adminService.checkAdmin(name)>0){
            return ServerResponse.createBySuccess("可以使用管理");
        }else{
            return ServerResponse.createByErrorMessage("管理员信息已经");
        }
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ServerResponse  checkEmail(String email){
        System.out.println(email);
        if(adminService.checkEmail(email)<0){
            return ServerResponse.createBySuccess("邮箱可以使用");
        }else{
            return ServerResponse.createByErrorMessage("邮箱已经存在");
        }
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public ServerResponse  checkPhone(@Param("phone") String phone){
        if(adminService.checkPhone(phone)<0){
            return ServerResponse.createBySuccess("电话可以使用");
        }else{
            return ServerResponse.createByErrorMessage("已经存在");
        }
    }

    @RequestMapping("/checkNameAndPass")
    @ResponseBody
    public ServerResponse  checkNameAndPass(@Param("name") String name,@Param("pass") String pass){
        if(adminService.checkAdmin(name)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByErrorMessage("输入的管理员和密码错误");
        }
    }

    @RequestMapping("/checkEmailAndPass")
    @ResponseBody
    public ServerResponse  checkEmailAndPass(@Param("email") String email,@Param("pass") String pass){
        if(adminService.checkEmail(email)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByErrorMessage("输入的邮箱和密码错误");
        }
    }

    @RequestMapping("/checkPhoneAndPass")
    @ResponseBody
    public ServerResponse  checkPhoneAndPass(@Param("phone") String phone,@Param("pass") String pass){
        if(adminService.checkPhone(phone)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByErrorMessage("输入的电话和密码错误");
        }
    }
}