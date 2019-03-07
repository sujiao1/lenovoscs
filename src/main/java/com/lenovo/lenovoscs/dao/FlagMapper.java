package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.Flag;
import com.lenovo.lenovoscs.bean.FlagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlagMapper {
    long countByExample(FlagExample example);

    int deleteByExample(FlagExample example);

    int deleteByPrimaryKey(Integer flag);

    int insert(Flag record);

    int insertSelective(Flag record);

    List<Flag> selectByExample(FlagExample example);

    Flag selectByPrimaryKey(Integer flag);

    int updateByExampleSelective(@Param("record") Flag record, @Param("example") FlagExample example);

    int updateByExample(@Param("record") Flag record, @Param("example") FlagExample example);

    int updateByPrimaryKeySelective(Flag record);

    int updateByPrimaryKey(Flag record);
}