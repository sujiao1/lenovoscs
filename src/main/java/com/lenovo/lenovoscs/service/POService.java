package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.dao.POMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POService {

    @Autowired
    POMapper poMapper;

    /**
     * 将PO信息插入到数据库中
     * @param po
     * @return
     */
    public int InsertPO(PO po){
        return poMapper.insertSelective(po);
    }


    /**
     * 得到所有PO数据信息
     * @return
     */
    public List<PO> getAllPO(){
        return poMapper.selectByExample(null);
    }

    public List<Object> getAllASN(){
        return poMapper.getAllASN(null);
    }

    public List<PO> getAllIV(){
        return poMapper.getAllIV(null);
    }


    /**
     * 得到PO信息
     * @param ponumber
     * @return
     */
    public PO selectPOByponumber(Integer ponumber){
        return poMapper.selectPOByponumber(ponumber);
    }

    /**
     * 更新po信息
     * @param po
     */
    public void updatePOByponumber(PO po){
        poMapper.updatePOByponumber(po);
    }

    /**
     * 更新po flag
     * @param po
     */
    public void updatePOFlag(PO po){
        poMapper.updatePOFlag(po);
    }

    /**
     * 更新ASN状态
     * @param po
     */
    public void updateASNFlag(PO po){
        poMapper.updateASNFlag(po);
    }

    public void updateIVFlag(PO po){
        poMapper.updateIVFlag(po);
    }
    /**
     * 删除PO信息
     * @param ponumber
     */
    public void deletePOByponumber(Integer ponumber){
        poMapper.deletePOByponumber(ponumber);
    }

}
