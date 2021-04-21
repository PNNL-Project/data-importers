package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu2;

@Mapper
public interface Ahu2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu2 record);

    int insertSelective(Ahu2 record);

    Ahu2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu2 record);

    int updateByPrimaryKey(Ahu2 record);
}