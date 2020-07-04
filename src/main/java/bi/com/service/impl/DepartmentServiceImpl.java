package bi.com.service.impl;

import bi.com.entity.Department;
import bi.com.mapper.DepartmentMapper;
import bi.com.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentMapper departmentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }
}