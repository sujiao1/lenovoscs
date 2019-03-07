package com.lenovo.lenovoscs.controller;

import com.lenovo.lenovoscs.bean.Flag;
import com.lenovo.lenovoscs.bean.Msg;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.service.PNService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/views")
public class PNController {

    @Autowired
    private PNService pnService;

    /**
     * 返回PN标记
     * @return
     */
    @RequestMapping("/getFlag")
    @ResponseBody
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
    @RequestMapping("/checkPNnumber")
    @ResponseBody
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
    @RequestMapping("/savePN")
    @ResponseBody
    public Msg savePN(@Valid PN pn){
        List<PN> pnList = pnService.getAllPN();
        /*for(PN pn1:pnList){
            if(pn1.getNumber()==pn.getNumber()){
                System.out.println("PN can not repeat");
                return Msg.fail();
            }
        }*/
        int countPn = pnService.savePN(pn);
        System.out.println("save="+countPn);
        if(countPn>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 查询所有PN
     * @return
     */
    @RequestMapping("/getAllPN")
    @ResponseBody
    public Msg getAllPN(Model model){
        List<PN> pnList = pnService.getAllPN();
        return Msg.success().add("pnList",pnList);
    }



    /**
     * 查询PO对应的PN
     * @param number
     * @return
     */
    @RequestMapping("/getPNequal/{number}")
    @ResponseBody
    public Msg getPNequalPONumber(@PathVariable("number") Integer number){
        //List<PN> pnList;
        //HashMap<Integer,Object> tempMap = new HashMap<>();
        List<PN> pnList = pnService.getPNequal(number);
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
    @RequestMapping("/getASNPNEqual/{ponumber}")
    @ResponseBody
    public Msg getASNPNEqual(Integer ponumber){
        List<PN> pnList = pnService.getASNPNEqual(ponumber);
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
    @RequestMapping("/getAllASNPN")
    @ResponseBody
    public Msg getAllASNPN(Model model){
        List<PN> pnList = pnService.getAllASNPN();
        return Msg.success().add("pnList",pnList);
    }

    /**
     *
     * @param pnnumber
     * @return
     */
    @RequestMapping("/selectPnBypnnumber/{pnnumber}")
    @ResponseBody
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
   /* public Msg updataPNBypnnumber(@Valid PN pn){ */
    public Msg updataPNBypnnumber(@Valid PN pn,@PathVariable("pnnumber") Integer pnnumber){
        System.out.println("update111");
        pnService.updataPNBypnnumber(pn);
        return Msg.success();
    }

    /**
     * delete PN
     * @param pnnumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deletePNByPNnumber/{pnnumber}")
    @ResponseBody
    public Msg deletePNByPNnumber(@PathVariable("pnnumber") Integer pnnumber){
        System.out.println("delete11111");
        pnService.deletePNByPNnumber(pnnumber);
        return Msg.success();
    }
}
