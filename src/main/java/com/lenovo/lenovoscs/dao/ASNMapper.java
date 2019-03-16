package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.ASN;
import com.lenovo.lenovoscs.bean.ASNExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ASNMapper {
    long countByExample(ASNExample example);

    int deleteByExample(ASNExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ASN record);

    int insertSelective(ASN record);

    List<ASN> selectByExample(ASNExample example);

    ASN selectByPrimaryKey(Integer id);

    List<ASN> selectASNByasnnumber(Integer asnnumber);

    List<ASN> getASNSearch(Integer ponumber);

    int updateByExampleSelective(@Param("record") ASN record, @Param("example") ASNExample example);

    int updateByExample(@Param("record") ASN record, @Param("example") ASNExample example);

    int updateByPrimaryKeySelective(ASN record);

    int updateByPrimaryKey(ASN record);
}
