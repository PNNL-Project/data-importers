package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Seb;

@Mapper
public interface SebMapper {
    int insert(Seb record);

    int insertSelective(Seb record);
}