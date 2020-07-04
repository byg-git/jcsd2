package bi.com.service.impl;

import bi.com.entity.Jc;
import bi.com.entity.JcWithBLOBs;
import bi.com.mapper.JcMapper;
import bi.com.service.JcService;
import org.springframework.stereotype.Service;

@Service("jcServiceImpl")
public class JcServiceImpl implements JcService {

    private JcMapper jcMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return jcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JcWithBLOBs record) {
        return jcMapper.insert(record);
    }

    @Override
    public int insertSelective(JcWithBLOBs record) {
        return jcMapper.insertSelective(record);
    }

    @Override
    public JcWithBLOBs selectByPrimaryKey(Integer id) {
        return jcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JcWithBLOBs record) {
        return jcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record) {
        return jcMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Jc record) {
        return jcMapper.updateByPrimaryKey(record);
    }
}