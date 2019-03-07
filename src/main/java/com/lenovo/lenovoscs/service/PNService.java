package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.Flag;
import com.lenovo.lenovoscs.bean.FlagExample;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PNExample;
import com.lenovo.lenovoscs.dao.FlagMapper;
import com.lenovo.lenovoscs.dao.PNMapper;
import com.lenovo.lenovoscs.dao.POMapper;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.idn.Punycode;

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
    public List<PN> getAllPN(){
        return pnMapper.selectByExample(null);
    }

    /**
     *得到和PONumber匹配的PN信息
     * @return
     */
    public List<PN> getPNequal(Integer number){
        return pnMapper.getPNequalByExample(number);
    }

    /**
     *得到和ASN匹配的PN信息
     * @param number
     * @return
     */
    public List<PN> getASNPNEqual(Integer number){
        return pnMapper.getASNPNEqual(number);
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
     * @param pnnumber
     * @return
     */
    public void deletePNByPNnumber(Integer pnnumber){
        pnMapper.deletePNByPNnumber(pnnumber);
    }
}
