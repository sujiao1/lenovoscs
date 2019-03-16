package com.lenovo.lenovoscs.dao;

import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.bean.POExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface POMapper {
    long countByExample(POExample example);

    int deleteByExample(POExample example);

    int deleteByPrimaryKey(Integer id);

    int deletePOByponumber(Integer ponumber);

    //int deletePNnumberByponumber(Integer ponumber);
    int deletePOByponumberpnnumber(@Param("ponumber") Integer ponumber, @Param("pnnumber") Integer pnnumber);

    int insert(PO record);

    int insertSelective(PO record);

    List<PO> selectByExample(POExample example);

    List<Object> getAllASN(POExample example);

    List<PO> getAllIV(POExample example);

    //List<PO> getPOByponumber(Integer ponumber);

    PO getPOByPonumberPnnumber(@Param("ponumber") Integer ponumber, @Param("pnnumber") Integer pnnumber);

    PO selectByPrimaryKey(Integer id);

    List<PO> selectPOByponumber(Integer ponumber);

    int updateByExampleSelective(@Param("record") PO record, @Param("example") POExample example);

    int updateByExample(@Param("record") PO record, @Param("example") POExample example);

    int updateByPrimaryKeySelective(PO record);

    int updateByPrimaryKey(PO record);

    int updatePOByponumber(PO record);

    int updatePOFlag(PO record);

    int updateASNFlag(PO record);

    int updateIVFlag(PO record);

}
