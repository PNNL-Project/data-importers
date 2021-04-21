package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu4;

@Mapper
public interface Ahu4Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu4 record);

    int insertSelective(Ahu4 record);

    Ahu4 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu4 record);

    int updateByPrimaryKey(Ahu4 record);
}