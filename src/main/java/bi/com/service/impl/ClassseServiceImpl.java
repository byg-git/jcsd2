package bi.com.service.impl;

import bi.com.entity.Classse;
import bi.com.mapper.ClassseMapper;
import bi.com.service.ClassseService;
import org.springframework.stereotype.Service;

@Service("classseServiceImpl")
public class ClassseServiceImpl implements ClassseService {

    private ClassseMapper classseMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classse record) {
        return classseMapper.insert(record);
    }

    @Override
    public int insertSelective(Classse record) {
        return classseMapper.insertSelective(record);
    }

    @Override
    public Classse selectByPrimaryKey(Integer id) {
        return classseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classse record) {
        return classseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classse record) {
        return classseMapper.updateByPrimaryKey(record);
    }
}