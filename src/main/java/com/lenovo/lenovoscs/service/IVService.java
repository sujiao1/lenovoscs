package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.IV;
import com.lenovo.lenovoscs.bean.IVStatus;
import com.lenovo.lenovoscs.dao.IVMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IVService {

    @Autowired
    private IVMapper ivMapper;

    /**
     * 将数据插入IV表中
     * @param iv
     * @return
     */
    public int insert(IV iv){
        return ivMapper.insertSelective(iv);
    }

    /**
     * 根据IVnumber得到IV数据
     * @param IVnumber
     * @return
     */
    public IV getIVByIvnumber(Integer IVnumber,Integer pnnumber){
        return ivMapper.getIVByIvnumber(IVnumber,pnnumber);
    }

    /**
     * 根据IVnumber查询IV信息并显示在返回
     * @param IVnumber
     * @return
     */
    public List<IVStatus> selectIVByIVnumber(Integer IVnumber){
        return ivMapper.selectIVByIVnumber(IVnumber);
    }

    /**
     * 根据搜索框输入的ponumber得到查询到的GR数据
     * @param ponumber
     * @return
     */
    public List<IVStatus> getIVSearch(Integer ponumber){
        return ivMapper.getIVSearch(ponumber);
    }

    /**
     * 根据搜索框输入的asnnumber得到查询到的GR数据
     * @param asnnumber
     * @return
     */
    public List<IVStatus> getIVSearchASN(Integer asnnumber){
        return ivMapper.getIVSearchASN(asnnumber);
    }

    /**
     * 更新IV信息
     * @param iv
     */
    public void updateIV(IV iv){
        ivMapper.updateIV(iv);
    }

    /**
     * 返回所有的IV信息
     * @return
     */
    public List<IVStatus> getAllIVs(){
        return ivMapper.getAllIVs();
    }


}
