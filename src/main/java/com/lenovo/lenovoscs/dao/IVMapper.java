package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.IV;
import com.lenovo.lenovoscs.bean.IVExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IVMapper {
    long countByExample(IVExample example);

    int deleteByExample(IVExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IV record);

    int insertSelective(IV record);

    List<IV> selectByExample(IVExample example);

    IV selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IV record, @Param("example") IVExample example);

    int updateByExample(@Param("record") IV record, @Param("example") IVExample example);

    int updateByPrimaryKeySelective(IV record);

    int updateByPrimaryKey(IV record);
}