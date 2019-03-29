package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.ASN;
import com.lenovo.lenovoscs.bean.ASNStatus;
import com.lenovo.lenovoscs.dao.ASNMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ASNService {

    @Autowired
    private ASNMapper asnMapper;

    /**
     * 得到所有的ASN数据
     * @return
     */
    public List<ASNStatus> getASNS(){
        return asnMapper.selectByExample();
    }

    public List<ASNStatus> selectASNByasnnumber(Integer asnnumber){
        return asnMapper.selectASNByasnnumber(asnnumber);
    }

    /**
     *
     * @param ponumber
     * @return
     */
    public List<ASNStatus> getASNSearch(Integer ponumber){
        return asnMapper.getASNSearch(ponumber);
    }
}
