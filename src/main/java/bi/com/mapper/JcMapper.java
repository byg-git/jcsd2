package bi.com.mapper;

import bi.com.entity.Jc;
import bi.com.entity.JcWithBLOBs;

public interface JcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JcWithBLOBs record);

    int insertSelective(JcWithBLOBs record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JcWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record);

    int updateByPrimaryKey(Jc record);
}