package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PNExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PNMapper {
    long countByExample(PNExample example);

    int deleteByExample(PNExample example);

    int deletePNByPonumber(Integer ponumber);

    int deleteByPrimaryKey(Integer id);

    int deletePNByPNnumber(Integer pnnumber);

    int insert(PN record);

    int insertSelective(PN record);

    List<PN> selectByExample(PNExample example);

    List<PN> selectAllASNPN(PNExample example);

    List<PN> getPNequalByExample(Integer number);

    List<PN> getASNPNEqual(Integer number);

    PN selectByPrimaryKey(Integer id);

    PN selectPNBypnnumber(Integer pnnumber);

    int updateByExampleSelective(@Param("record") PN record, @Param("example") PNExample example);

    int updateByExample(@Param("record") PN record, @Param("example") PNExample example);

    int updateByPrimaryKeySelective(PN record);

    int updateByPrimaryKey(PN record);

    int updataPNBypnnumber(PN record);
}
