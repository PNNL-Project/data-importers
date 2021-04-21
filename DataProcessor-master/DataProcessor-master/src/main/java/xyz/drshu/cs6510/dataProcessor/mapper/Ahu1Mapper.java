package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu1;

@Mapper
public interface Ahu1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu1 record);

    int insertSelective(Ahu1 record);

    Ahu1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu1 record);

    int updateByPrimaryKey(Ahu1 record);
}