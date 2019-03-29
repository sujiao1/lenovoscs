package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.ASN;
import com.lenovo.lenovoscs.bean.ASNExample;
import java.util.List;

import com.lenovo.lenovoscs.bean.ASNStatus;
import org.apache.ibatis.annotations.Param;

public interface ASNMapper {
    long countByExample(ASNExample example);

    int deleteByExample(ASNExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ASN record);

    int insertSelective(ASN record);

    List<ASNStatus> selectByExample();

    ASN selectByPrimaryKey(Integer id);

    List<ASNStatus> selectASNByasnnumber(Integer asnnumber);

    List<ASNStatus> getASNSearch(Integer ponumber);

    int updateByExampleSelective(@Param("record") ASN record, @Param("example") ASNExample example);

    int updateByExample(@Param("record") ASN record, @Param("example") ASNExample example);

    int updateByPrimaryKeySelective(ASN record);

    int updateByPrimaryKey(ASN record);
}
