package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Common;

@Mapper
public interface CommonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Common record);

    int insertSelective(Common record);

    Common selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Common record);

    int updateByPrimaryKey(Common record);
}