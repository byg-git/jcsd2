package bi.com.mapper;

import bi.com.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    List<Admin> selectAll();
    int deleteByPrimaryKey(Integer id);
    int insert(Admin record);
    int insertSelective(Admin record);
    Admin selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Admin record);
    int updateByPrimaryKey(Admin record);

    int checkAdmin(@Param("name") String name); //名称进行查询
    int checkEmail(@Param("Email") String email); //邮箱进行查询
    int checkPhone(@Param("phone") String phone); //电话进行查询
    int checkPass(@Param("pass") String pass);  //密码进行查询
}