package bi.com.service;

import bi.com.entity.Classse;

public interface ClassseService {
    int deleteByPrimaryKey(Integer id);

    int insert(Classse record);

    int insertSelective(Classse record);

    Classse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classse record);

    int updateByPrimaryKey(Classse record);
}