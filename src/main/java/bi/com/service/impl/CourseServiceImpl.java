package bi.com.service.impl;

import bi.com.entity.Course;
import bi.com.mapper.CourseMapper;
import bi.com.service.CourseService;
import org.springframework.stereotype.Service;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }
}