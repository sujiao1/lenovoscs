package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.IV;
import com.lenovo.lenovoscs.bean.IVExample;
import java.util.List;

import com.lenovo.lenovoscs.bean.IVStatus;
import org.apache.ibatis.annotations.Param;

public interface IVMapper {
    long countByExample(IVExample example);

    int deleteByExample(IVExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IV record);

    int insertSelective(IV record);

    IV getIVByIvnumber(@Param("IVnumber") Integer IVnumber,@Param("pnnumber") Integer pnnumber);

    List<IV> selectByExample(IVExample example);

    List<IVStatus> getAllIVs();

    List<IVStatus> selectIVByIVnumber(Integer IVnumber);

    List<IVStatus> getIVSearch(Integer ponumber);

    List<IVStatus> getIVSearchASN(Integer asnnumber);

    IV selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IV record, @Param("example") IVExample example);

    int updateByExample(@Param("record") IV record, @Param("example") IVExample example);

    int updateByPrimaryKeySelective(IV record);

    int updateByPrimaryKey(IV record);

    int updateIV(IV record);
}
