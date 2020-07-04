package bi.com.service.impl;

import bi.com.entity.Teacher;
import bi.com.mapper.TeacherMapper;
import bi.com.service.TeacherService;
import org.springframework.stereotype.Service;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }
}