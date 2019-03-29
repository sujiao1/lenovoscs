package com.lenovo.lenovoscs.controller;

import com.lenovo.lenovoscs.bean.*;
import com.lenovo.lenovoscs.service.MapperService;
import com.lenovo.lenovoscs.service.PNService;
import com.lenovo.lenovoscs.service.POService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/views")
public class PNController {

    @Autowired
    private PNService pnService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private POService poService;

    /**
     * 返回PN标记
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getFlag")
    @ResponseBody
    @ApiOperation("返回flag表中所有的状态信息")
    public Msg getFlag(){
        System.out.println("11111");
        List<Flag> flagList = pnService.getFlag();
        for(Flag flag:flagList){
            System.out.println(flag);
        }
        return Msg.success().add("flagList",flagList);
    }

    /**
     * 校验PNnumber是否正确
     * @param pnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/checkPNnumber")
    @ResponseBody
    @ApiOperation("校验PNnumber是否正确")
    public Msg checkPNnumber(@RequestParam("pnnumber") Integer pnnumber){
        boolean checkPNnumber = pnService.checkPNnumber(pnnumber);
        if(checkPNnumber){
            return Msg.success();
        }else {
            return Msg.fail().add("msg","This PNnumber can not be use!");
        }
    }

    /**
     * 保存pn信息
     * @param pn
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/savePN")
    @ResponseBody
    @ApiOperation("保存pn信息")
    public Msg savePN(@Valid PN pn){
        //List<PN> pnList = pnService.getAllPN();
        /*for(PN pn1:pnList){
            if(pn1.getNumber()==pn.getNumber()){
                System.out.println("PN can not repeat");
                return Msg.fail();
            }
        }*/
        //pn.setFlag(1);
        int countPn = pnService.savePN(pn);
        Mapper mapper = new Mapper();
        mapper.setPonumber(pn.getNumber());
        mapper.setPnnumber(pn.getPnnumber());
        int countMapper = mapperService.saveMapper(mapper);
        List<PO> poList = poService.getPO(pn.getNumber());
        for(PO po:poList){
            System.out.println("po="+po.getPonumber());
            if(po.getPnnumber() == null){
                po.setPnnumber(pn.getPnnumber());
                po.setPnQuantity(pn.getPnQuantity());
                poService.updatePOBypnnumber(po);
            }else {
                PO poRecord = new PO();
                poRecord.setPonumber(pn.getNumber());
                poRecord.setPnnumber(pn.getPnnumber());
                poRecord.setPnQuantity(pn.getPnQuantity());
                poRecord.setSoldTo(po.getSoldTo());
                poRecord.setPayment(po.getPayment());
                poRecord.setShipTo(po.getShipTo());
                poRecord.setOrderType(po.getOrderType());
                poRecord.setExchangeProvisionItem(po.getExchangeProvisionItem());
                poRecord.setConditionItem(po.getConditionItem());
                poRecord.setRemark(po.getRemark());
                poRecord.setCarrier(po.getCarrier());
                poRecord.setCustomer(po.getCustomer());
                poRecord.setNetDueDate(po.getNetDueDate());
                poRecord.setPoDate(po.getPoDate());
                poRecord.setDeliveryDate(po.getDeliveryDate());
                poRecord.setDropOrderTime(po.getDropOrderTime());
                poRecord.setTargetDate(po.getTargetDate());
                poRecord.setCreatedBy(po.getCreatedBy());
                poRecord.setLastModifiedBy(po.getLastModifiedBy());
                poService.InsertPO(poRecord);
            }
        }
        /**/
        //System.out.println(poRecord.getPnnumber());
        //System.out.println("save="+countPn);
        if(countPn>0&&countMapper>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 查询所有PN
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAllPN")
    @ResponseBody
    @ApiOperation("查询所有PN，返回PN表中所有PN信息")
    public Msg getAllPN(Model model){
        List<PNStatus> pnList = pnService.getAllPN();
        return Msg.success().add("pnList",pnList);
    }



    /**
     * 查询PO对应的PN
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getPNequal/{number}")
    @ResponseBody
    @ApiOperation("得到ASN下的所有PN信息")
    public Msg getPNequalASNNumber(@PathVariable("number") Integer number){
        System.out.println(number);
        List<PNStatus> pnList = pnService.getPNequal(number);
        for  ( int  i  =   0 ; i  <  pnList.size()  -   1 ; i ++ )  {
            for  ( int  j  =  pnList.size()  -   1 ; j  >  i; j -- )  {
                if  (pnList.get(j).getId() == pnList.get(i).getId())  {
                    pnList.remove(j);
                }
            }
        }
        return Msg.success().add("pnList",pnList);
    }

    /**
     * 得到和ASN匹配的PN信息
     * @param ponumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getPNequalPOnumber/{ponumber}")
    @ResponseBody
    @ApiOperation("得到PO下的所有PN信息")
    public Msg getPNequalPOnumber(@PathVariable("ponumber") Integer ponumber){
        List<PNStatus> pnList = pnService.getPNequalPOnumber(ponumber);
        System.out.println(ponumber);
        for(int a = 0;a<pnList.size()-1;a++){
            for(int b=pnList.size()-1;b>a;b--){
                if(pnList.get(b).getId() == pnList.get(a).getId()){
                    pnList.remove(b);
                }
            }
        }
        return Msg.success().add("pnList",pnList);
    }


    /**
     * 得到IV下的相应PN
     * @param ivnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getPNequalivnumber/{ivnumber}")
    @ResponseBody
    @ApiOperation("得到IV下的所有PN信息")
    public Msg getPNequalivnumber(@PathVariable("ivnumber") Integer ivnumber){
        List<PNStatus> pnList = pnService.getPNequalivnumber(ivnumber);
        System.out.println(ivnumber);
        for(int a = 0;a<pnList.size()-1;a++){
            for(int b=pnList.size()-1;b>a;b--){
                if(pnList.get(b).getId() == pnList.get(a).getId()){
                    pnList.remove(b);
                }
            }
        }
        return Msg.success().add("pnList",pnList);
    }
//    public static List<Object> mySort(List<Object> list){
////        HashMap<Integer,Object> tempMap = new HashMap<>();
////        for (Object obj : list) {
////            int key = obj.getId();
////// containsKey(Object key) 该方法判断Map集合对象中是否包含指定的键名。如果Map集合中包含指定的键名，则返回true，否则返回false
////// containsValue(Object value)    value：要查询的Map集合的指定键值对象.如果Map集合中包含指定的键值，则返回true，否则返回false
////            if(tempMap.containsKey(key)){
////                PN tempUser = new PN(key,
////                        tempMap.get(key) + user.getName(),
////                        tempMap.get(key).getAge());//user.getAge();
//////HashMap是不允许key重复的，所以如果有key重复的话，那么前面的value会被后面的value覆盖
////                tempMap.put(key, tempUser);
////            }else{
////                tempMap.put(key, user);
////            }
////        }
////        List<User> tempList = new ArrayList<>();
////        for(int key : tempMap.keySet()){
////            tempList.add(tempMap.get(key));
////        }
////        return tempList;
////    }

    public   static   List  removeDuplicate(List list)  {
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                }
            }
        }
        return list;
    }
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAllASNPN")
    @ResponseBody
    @ApiOperation("得到ASN下的所有PN信息,该方法已被替代")
    public Msg getAllASNPN(Model model){
        List<PN> pnList = pnService.getAllASNPN();
        return Msg.success().add("pnList",pnList);
    }

    /**
     *
     * @param pnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectPnBypnnumber/{pnnumber}")
    @ResponseBody
    @ApiOperation("根据pnumber的到对应的pnnumber")
    public Msg selectPnBypnnumber(@PathVariable("pnnumber") Integer pnnumber){
        PN pn = pnService.getPNBypnnumber(pnnumber);
        return Msg.success().add("pn",pn);
    }

    /**
     * update PN
     * @param pn
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/updataPNBypnnumber/{pnnumber}")
    @ResponseBody
    @ApiOperation("点击模态框更新按钮更新PN信息")
    //此处应判断该pn是否位于asn中，若是，更新pn的flag为asn对应pn的flag,若不是，设置flag为1；
    //更新poquantity是否同时更新PO，ASNquantity信息
   /* public Msg updataPNBypnnumber(@Valid PN pn){ */
    public Msg updataPNBypnnumber(@Valid PN pn,@PathVariable("pnnumber") Integer pnnumber){
        System.out.println("update111");
        pn.setFlag(1);
        pnService.updataPNBypnnumber(pn);
        PO poRecord = poService.getPOByPonumberPnnumber(pn.getNumber(),pn.getPnnumber());
        System.out.println(poRecord.getPnnumber());
        System.out.println(poRecord.getPnQuantity());
        System.out.println(poRecord.getPonumber());
        if(poRecord!=null){
            //poRecord.setPnnumber(pn.getPnnumber());
            poRecord.setPnQuantity(pn.getPnQuantity());
            poService.updatePOByponumber(poRecord);
        }
        return Msg.success();
    }

    /**
     * delete PN
     * @param pnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deletePNByPNnumber/{pnnumber}")
    @ResponseBody
    @ApiOperation("删除PO下的pn信息")
    public Msg deletePNByPNnumber(@PathVariable("pnnumber") Integer pnnumber){
        System.out.println("delete11111");
        PN pn = pnService.getPNBypnnumber(pnnumber);
        //PO po = poService.getPOByPonumberPnnumber(pn.getNumber(),pnnumber);
        poService.deletePOByponumberpnnumber(pn.getNumber(),pnnumber);
        pnService.deletePNByPNnumber(pnnumber);
        mapperService.deletePNByPNnumber(pnnumber);
        return Msg.success();
    }
}
