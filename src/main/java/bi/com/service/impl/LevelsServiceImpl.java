package bi.com.service.impl;

import bi.com.entity.Levels;
import bi.com.mapper.LevelsMapper;
import bi.com.service.LevelsService;
import org.springframework.stereotype.Service;

@Service("levelsServiceImpl")
public class LevelsServiceImpl implements LevelsService {

    private LevelsMapper levelsMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return levelsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Levels record) {
        return levelsMapper.insert(record);
    }

    @Override
    public int insertSelective(Levels record) {
        return levelsMapper.insertSelective(record);
    }

    @Override
    public Levels selectByPrimaryKey(Integer id) {
        return levelsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Levels record) {
        return levelsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Levels record) {
        return levelsMapper.updateByPrimaryKey(record);
    }
}