package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Vav;

@Mapper
public interface VavMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vav record);

    int insertSelective(Vav record);

    Vav selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vav record);

    int updateByPrimaryKey(Vav record);
}