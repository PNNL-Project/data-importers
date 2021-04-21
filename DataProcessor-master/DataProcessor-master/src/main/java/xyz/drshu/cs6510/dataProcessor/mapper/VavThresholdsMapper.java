package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.VavThresholds;

@Mapper
public interface VavThresholdsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VavThresholds record);

    int insertSelective(VavThresholds record);

    VavThresholds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VavThresholds record);

    int updateByPrimaryKey(VavThresholds record);
}