package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.Mapper;
import com.lenovo.lenovoscs.bean.MapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MapperMapper {
    long countByExample(MapperExample example);

    int deleteByExample(MapperExample example);

    int deleteByPrimaryKey(Integer id);

    int deletePNByPNnumber(Integer pnnumber);

    int deleteByPonumber(Integer ponumber);

    int insert(Mapper record);

    int insertSelective(Mapper record);

    List<Mapper> selectByExample(MapperExample example);

    Mapper SelectMapperbyPoAndPN(@Param("ponumber") Integer ponumber, @Param("pnnumber") Integer pnnumber);

    Mapper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mapper record, @Param("example") MapperExample example);

    int updateByExample(@Param("record") Mapper record, @Param("example") MapperExample example);

    int updateByPrimaryKeySelective(Mapper record);

    int updateByPrimaryKey(Mapper record);

    int updateByPoAndPn(Mapper record);

    int updateMapper(Mapper record);

    int updateMapperIV(Mapper record);
}
