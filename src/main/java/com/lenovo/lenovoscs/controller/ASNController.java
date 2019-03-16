package com.lenovo.lenovoscs.controller;

import com.lenovo.lenovoscs.bean.ASN;
import com.lenovo.lenovoscs.bean.Msg;
import com.lenovo.lenovoscs.service.ASNService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.MacSpi;
import java.util.List;

@RestController
@RequestMapping("/views")
public class ASNController {

    @Autowired
    private ASNService asnService;

    /**
     * 返回ASN表中所有的ASN数据
     * @return
     */
    @RequestMapping("/getASNS")
    @ResponseBody
    @ApiOperation("返回ASN表中所有的ASN数据")
    public Msg getASNS(){
       List<ASN> asnList = asnService.getASNS();
       return Msg.success().add("asnList",asnList);
    }

    /**
     * 根据asnnumber得到ASN信息
     * @param asnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectASNByasnnumber/{asnnumber}")
    @ResponseBody
    public Msg selectASNByasnnumber(@PathVariable("asnnumber") Integer asnnumber){
        List<ASN> asnList = asnService.selectASNByasnnumber(asnnumber);
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
    public Msg getASNSearch(@PathVariable("ponumber") Integer ponumber){
        List<ASN> asnList = asnService.getASNSearch(ponumber);
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
