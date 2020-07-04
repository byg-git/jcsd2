package bi.com.service.impl;

import bi.com.entity.Major;
import bi.com.mapper.MajorMapper;
import bi.com.service.MajorService;
import org.springframework.stereotype.Service;

@Service("majorServiceImpl")
public class MajorServiceImpl implements MajorService {

    private MajorMapper majorMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return majorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    @Override
    public int insertSelective(Major record) {
        return majorMapper.insertSelective(record);
    }

    @Override
    public Major selectByPrimaryKey(Integer id) {
        return majorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return majorMapper.updateByPrimaryKey(record);
    }
}