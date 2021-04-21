package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu3;

@Mapper
public interface Ahu3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu3 record);

    int insertSelective(Ahu3 record);

    Ahu3 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu3 record);

    int updateByPrimaryKey(Ahu3 record);
}