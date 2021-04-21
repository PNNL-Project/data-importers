package xyz.drshu.cs6510.dataProcessor.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.drshu.cs6510.dataProcessor.model.Ahu1Thresholds;

@Mapper
public interface Ahu1ThresholdsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ahu1Thresholds record);

    int insertSelective(Ahu1Thresholds record);

    Ahu1Thresholds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ahu1Thresholds record);

    int updateByPrimaryKey(Ahu1Thresholds record);
}