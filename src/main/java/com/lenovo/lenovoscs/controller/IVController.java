package com.lenovo.lenovoscs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.lenovoscs.bean.*;
import com.lenovo.lenovoscs.service.IVService;
import com.lenovo.lenovoscs.service.MapperService;
import com.lenovo.lenovoscs.service.PNService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/views")
public class IVController {

    @Autowired
    private IVService ivService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private PNService pnService;

    /**
     * 得到所有的IV数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAllIVs")
    @ResponseBody
    @ApiOperation("返回一条数据库中所有GR数据")
    public Msg getAllIVs(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<IVStatus> ivStatusList = ivService.getAllIVs();
        List<Mapper> mapperList = mapperService.getAllMapper();
        List<PN> pnList = pnService.getAllPNS();
        for(IVStatus ivStatus:ivStatusList){
            for(Mapper mapper:mapperList){
                if(ivStatus.getPnnumber() == mapper.getPnnumber())
                    mapper.setIvnumber(ivStatus.getIvnumber());
                // Integer pnnumber = mapper.getPnnumber();
                mapperService.updateMapperIV(mapper);
            }
            for(PN pn1:pnList){
                if(ivStatus.getPnnumber() == pn1.getPnnumber()){
                    //PN pn = new PN();
                    pn1.setFlag(ivStatus.getFlag());
                    pnService.updataPNFlagByIV(pn1);
                }
            }
        }
        PageInfo pageInfo = new PageInfo(ivStatusList,5);
        return Msg.success().add("pageInfo",pageInfo);
       // return Msg.success().add("IVList",ivStatusList);
    }

    /**
     * 根据ivnumber得到对应的iv信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectIVByIVnumber/{ivnumber}")
    @ResponseBody
    @ApiOperation("根据ivnumber得到对应的iv信息")
    public Msg selectIVByIVnumber(@PathVariable("ivnumber") Integer ivnumber){
        List<IVStatus> ivList = ivService.selectIVByIVnumber(ivnumber);
        for(int a = 0;a < ivList.size()-1;a++){
            for(int b = ivList.size()-1;b > a;b--){
                if(ivList.get(b).getIvnumber() == ivList.get(a).getIvnumber()){
                    ivList.remove(b);
                }
            }
        }
        return Msg.success().add("ivList",ivList);
    }

    /**
     * 根据搜索框输入的ponumber得到查询到的GR数据
     * @param ponumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getIVSearch/{ponumber}")
    @ResponseBody
    @ApiOperation("根据搜索框输入的ponumber得到查询到的GR数据")
    public Msg getIVSearch(@PathVariable("ponumber") Integer ponumber){
        List<IVStatus> ivStatusList = ivService.getIVSearch(ponumber);
        for(int a = 0;a < ivStatusList.size()-1;a++){
            for(int b = ivStatusList.size()-1;b > a;b--){
                if(ivStatusList.get(b).getIvnumber() == ivStatusList.get(a).getIvnumber()){
                    ivStatusList.remove(b);
                }
            }
        }
        return Msg.success().add("ivStatusList",ivStatusList);
    }

    /**
     * 根据搜索框输入的asnnumber得到查询到的GR数据
     * @param asnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getIVSearchASN/{asnnumber}")
    @ResponseBody
    @ApiOperation("根据搜索框输入的asnnumber得到查询到的GR数据")
    public Msg getIVSearchASN(@PathVariable("asnnumber") Integer asnnumber){
        List<IVStatus> ivStatusList1 = ivService.getIVSearchASN(asnnumber);
        for(int a = 0;a < ivStatusList1.size()-1;a++){
            for(int b = ivStatusList1.size()-1;b > a;b--){
                if(ivStatusList1.get(b).getIvnumber() == ivStatusList1.get(a).getIvnumber()){
                    ivStatusList1.remove(b);
                }
            }
        }
        return Msg.success().add("ivStatusList1",ivStatusList1);
    }
}
