package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu3Thresholds;

@Mapper
public interface Ahu3ThresholdsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu3Thresholds record);

    int insertSelective(Ahu3Thresholds record);

    Ahu3Thresholds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu3Thresholds record);

    int updateByPrimaryKey(Ahu3Thresholds record);
}