package com.lenovo.lenovoscs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.lenovoscs.bean.*;
import com.lenovo.lenovoscs.dao.PNMapper;
import com.lenovo.lenovoscs.service.ASNService;
import com.lenovo.lenovoscs.service.MapperService;
import com.lenovo.lenovoscs.service.PNService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.MacSpi;
import java.util.List;

@RestController
@RequestMapping("/views")
public class ASNController {

    @Autowired
    private ASNService asnService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private PNService pnService;

    /**
     * 返回ASN表中所有的ASN数据
     * @return
     */
    @RequestMapping(value = "/getASNS",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("返回ASN表中所有的ASN数据")
    public Msg getASNS(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<ASNStatus> asnList = asnService.getASNS();
        List<Mapper> mapperList = mapperService.getAllMapper();
       //List<PNStatus> pnList = pnService.getAllPN();
        List<PN> pnList = pnService.getAllPNS();
        for(ASNStatus asnStatus:asnList){
           for(Mapper mapper:mapperList){
               if(asnStatus.getPnnumber() == mapper.getPnnumber())
               mapper.setAsnnumber(asnStatus.getAsnnumber());
              // Integer pnnumber = mapper.getPnnumber();
               mapperService.updateMapper(mapper);
           }
           for(PN pn1:pnList){
               if(asnStatus.getPnnumber() == pn1.getPnnumber()){
                   //PN pn = new PN();
                   //pn.setFlag(asnStatus.getFlag());
                   pn1.setFlag(asnStatus.getFlag());
                   pnService.updataPNFlagByasn(pn1);
               }
           }
       }
        PageInfo pageInfo = new PageInfo(asnList,5);
        return Msg.success().add("pageInfo",pageInfo);
       //return Msg.success().add("asnList",asnList);
    }

    /**
     * 根据asnnumber得到ASN信息
     * @param asnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectASNByasnnumber/{asnnumber}")
    @ResponseBody
    @ApiOperation("根据ASNnumber返回一条ASN的详细数据")
    public Msg selectASNByasnnumber(@PathVariable("asnnumber") Integer asnnumber){
        List<ASNStatus> asnList = asnService.selectASNByasnnumber(asnnumber);
        for(int a = 0;a<asnList.size()-1;a++){
            for(int b=asnList.size()-1;b>a;b--){
                if(asnList.get(b).getAsnnumber() == asnList.get(a).getAsnnumber()){
                    asnList.remove(b);
                }
            }
        }
        return Msg.success().add("asn",asnList);
    }

    /**
     * 根据搜索框输入的数值查询数据记录
     * @param ponumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getASNSearch/{ponumber}")
    @ResponseBody
    @ApiOperation("输入POnumber,点击search按钮,返回一条ponumber对应的所有的ASN")
    public Msg getASNSearch(@PathVariable("ponumber") Integer ponumber){
        //List<ASN> asnList = asnService.getASNSearch(ponumber);
        List<ASNStatus> asnList = asnService.getASNSearch(ponumber);
        for(int a = 0;a<asnList.size()-1;a++){
            for(int b=asnList.size()-1;b>a;b--){
                if(asnList.get(b).getId() == asnList.get(a).getId()){
                    asnList.remove(b);
                }
            }
        }
        return Msg.success().add("asnList",asnList);
    }
}
