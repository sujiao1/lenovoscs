package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.*;
import com.lenovo.lenovoscs.dao.FlagMapper;
import com.lenovo.lenovoscs.dao.PNMapper;
import com.lenovo.lenovoscs.dao.POMapper;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PNService {

    @Autowired
    private PNMapper pnMapper;

    @Autowired
    private FlagMapper flagMapper;

    /**
     * 返回PN标记
     * @return
     */
    public List<Flag> getFlag(){
        return flagMapper.selectByExample(null);
    }

    /**
     * 校验PNnumber是否存在
     * @param pnnumber
     * @return
     */
    public boolean checkPNnumber(Integer pnnumber){
        PNExample pnExample = new PNExample();
        PNExample.Criteria criteria = pnExample.createCriteria();
        criteria.andPnnumberEqualTo(pnnumber);
        long count = pnMapper.countByExample(pnExample);
        return count == 0;
    }

    /**
     * 保存pn
     * @param pn
     * @return
     */
    public int savePN(PN pn){
        return pnMapper.insert(pn);
    }

    /**
     * 查询PN信息
     * @return
     */
    public List<PNStatus> getAllPN(){
        return pnMapper.selectByExample();
    }

    public List<PN> getAllPNS(){
        return pnMapper.selectPNByExample(null);
    }
    /**
     *得到和PONumber匹配的PN信息
     * @return
     */
    public List<PNStatus> getPNequal(Integer number){
        return pnMapper.getPNequalByExample(number);
    }

    /**
     *得到和ASN匹配的PN信息
     * @param number
     * @return
     */
    public List<PNStatus> getPNequalPOnumber(Integer number){
        return pnMapper.getPNequalPOnumber(number);
    }

    /**
     * 得到和IV匹配的PN信息
     * @param IVnumber
     * @return
     */
    public List<PNStatus> getPNequalivnumber(Integer IVnumber){
        return pnMapper.getPNequalivnumber(IVnumber);
    }
    /**
     * 查询所有ASN信息
     * @return
     */
    public List<PN> getAllASNPN(){return pnMapper.selectAllASNPN(null);}

    /**
     *
     * @param pnnumber
     * @return
     */
    public PN getPNBypnnumber(Integer pnnumber){
        return pnMapper.selectPNBypnnumber(pnnumber);
    }

    /**
     *
     * @param pn
     * @return
     */
    public void updataPNBypnnumber(PN pn){
        pnMapper.updataPNBypnnumber(pn);
    }

    /**
     *
     * @param pn
     */
    public void updataPNFlagByasn(PN pn){
        pnMapper.updataPNFlagByasn(pn);
    }

    /**
     *
     * @param pnStatus
     */
    public void updataPNFlagByIV(PN pn){
        pnMapper.updataPNFlagByIV(pn);
    }

    /**
     *
     * @param pnnumber
     * @return
     */
    public void deletePNByPNnumber(Integer pnnumber){
        pnMapper.deletePNByPNnumber(pnnumber);
    }

    /**
     *
     * @param popnumber
     */
    public void deletePNByPonumber(Integer popnumber){
        pnMapper.deletePNByPonumber(popnumber);
    }
}
