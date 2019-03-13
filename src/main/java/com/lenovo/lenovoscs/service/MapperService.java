package com.lenovo.lenovoscs.service;

import com.lenovo.lenovoscs.bean.Mapper;
import com.lenovo.lenovoscs.dao.MapperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    @Autowired
    private MapperMapper mapperMapper;

    /**
     * 将mapper插入到数据库中
     * @param mapper
     * @return
     */
    public int saveMapper(Mapper mapper){
        return mapperMapper.insert(mapper);
    }

    /**
     * 删除Mapper记录
     * @param pnnumber
     */
    public void deletePNByPNnumber(Integer pnnumber){
        mapperMapper.deletePNByPNnumber(pnnumber);
    }

    /**
     *删除提供的POnumber所在的Mapper记录
     * @param ponumber
     */
    public void deleteByPonumber(Integer ponumber){
        mapperMapper.deleteByPonumber(ponumber);
    }
}
