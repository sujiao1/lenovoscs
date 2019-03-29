package com.lenovo.lenovoscs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.lenovoscs.bean.*;
import com.lenovo.lenovoscs.dao.POMapper;
import com.lenovo.lenovoscs.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/views")
public class POController {

    @Autowired
   private POService poService;

    @Autowired
    private PNService pnService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private ASNService asnService;

    @Autowired
    private IVService ivService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/insertPO",method = RequestMethod.POST )
    @ResponseBody
    @ApiOperation("向PO表中新增一条PO数据")
    public void insertPO(@Valid PO po, BindingResult bindingResult,HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            //校验错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息:" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            try {
                response.sendRedirect("../views/podetail.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*return "redirect:/views/podetail.html";*/
        } else {
            poService.InsertPO(po);
            try {
                response.sendRedirect("../views/podetail.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*return "redirect:/views/podetail.html";*/
        }

        }


    /**
     * 查询所有PO数据
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAllPO")
    @ResponseBody
    @ApiOperation("返回PO表中所有PO信息")
    public Msg getAllPO(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<PO> poList = poService.getAllPO();
        PageInfo pageInfo = new PageInfo(poList,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 查询所有的ASN信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getAllASN")
    @ResponseBody
    @ApiOperation("返回ASN表中所有ASN数据，该方法暂时未用到")
    public Msg getAllASN(){
        List<Object> poList = poService.getAllASN();
        return Msg.success().add("poList",poList);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAllIV")
    @ResponseBody
    @ApiOperation("返回IV表中所有IV信息，该方法暂时未用到")
    public Msg getAllIV()
    {
        List<IVStatus> poList = poService.getAllIV();
        return Msg.success().add("poList",poList);
    }
    /**
     * 根据POnumber查询PO信息
     * @param ponumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectPOByponumber/{ponumber}")
    @ResponseBody
    @ApiOperation("根据前一页面点击information获取POnumber，下一页根据传过来的ponumber显示po详细信息")
    public Msg selectPOByponumber(@PathVariable("ponumber") Integer ponumber){
        List<PO> pos = poService.selectPOByponumber(ponumber);
        for(int a = 0;a<pos.size()-1;a++){
            for(int b=pos.size()-1;b>a;b--){
                if(pos.get(b).getPonumber() == pos.get(a).getPonumber()){
                    pos.remove(b);
                }
            }
        }
        return Msg.success().add("po",pos);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/selectPOById/{id}")
    @ResponseBody
    @ApiOperation("根据po的id返回po信息，该方法暂时未用到")
    public Msg selectPOById(@PathVariable("id") Integer id){
        PO po = poService.selectPOById(id);
        return Msg.success().add("po",po);
    }

    /**
     * 更新PO信息
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePOByponumber")
    @ResponseBody
    @ApiOperation("点击edit,更新po信息")
    public void updatePOByponumber(@Valid PO po, HttpServletResponse response){
        poService.updatePOByponumber(po);
        try {
            response.sendRedirect("../podetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新flag
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePOFlag")
    @ResponseBody
    @ApiOperation("点击confirm，更新PO的flag信息，该方法暂时搁置")
    public void updatePOFlag(@Valid PO po,HttpServletResponse response){
        poService.updatePOFlag(po);
        try {
            response.sendRedirect("../podetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println();
    }

    /**
     * 更新ASN信息
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/updateASNFlag")
    @ResponseBody
    @ApiOperation("点击ASN的confirm,更新flag信息")
    public Msg updateASNFlag(@Valid PO po,HttpServletResponse response){
        List<ASNStatus> asnStatusList = asnService.getASNS();
        List<IV> ivList = new ArrayList<>();
        for(ASNStatus asnStatus:asnStatusList) {
            IV iv = new IV();
            iv.setIvnumber(asnStatus.getAsnnumber());
            iv.setPnnumber(asnStatus.getPnnumber());
            iv.setPnQuantity(asnStatus.getPnQuantity());
            iv.setPayment(asnStatus.getPayment());
            iv.setShipTo(asnStatus.getShipTo());
            iv.setSoldTo(asnStatus.getSoldTo());
            iv.setOrderType(asnStatus.getOrderType());
            iv.setExchangeProvisionItem(asnStatus.getExchangeProvisionItem());
            iv.setCarrier(asnStatus.getConditionItem());
            iv.setRemark(asnStatus.getRemark());
            iv.setCarrier(asnStatus.getCarrier());
            iv.setNetDueDate(asnStatus.getNetDueDate());
            iv.setPoDate(asnStatus.getPoDate());
            iv.setDeliveryDate(asnStatus.getDeliveryDate());
            iv.setDropOrderTime(asnStatus.getDropOrderTime());
            iv.setTargetDate(asnStatus.getTargetDate());
            iv.setCreatedBy(asnStatus.getCreatedBy());
            iv.setLastModifiedBy(asnStatus.getLastModifiedBy());
            iv.setFlag(asnStatus.getFlag()+1);
            ivList.add(iv);
        }
        for(IV iv:ivList){
            Integer IVnumber = iv.getIvnumber();
            Integer pnnumber = iv.getPnnumber();
            IV iv1 = ivService.getIVByIvnumber(IVnumber,pnnumber);
            System.out.println(iv.getPnQuantity());
            if(iv1 == null) {
                ivService.insert(iv);
                System.out.println("插入"+iv);
            }else {
                ivService.updateIV(iv);
                System.out.println("更新"+iv);
            }
        }
        //poService.updateASNFlag(po);
        return Msg.success();
        /*try {
            response.sendRedirect("../views/asndetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 更新IV信息
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateIVFlag")
    @ResponseBody
    @ApiOperation("点击IV的confirm,更新flag信息，该方法暂时搁置")
    public void updateIVFlag(@Valid PO po,HttpServletResponse response){
        poService.updateIVFlag(po);
        /*return Msg.success();*/
        try {
            response.sendRedirect("../ivdetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deletePOByponumber/{ponumber}")
    @ResponseBody
    @ApiOperation("点击po的delete,删除PO表中的PO信息")
    public void deletePOByponumber(@PathVariable("ponumber") Integer ponumber,HttpServletResponse response){
        poService.deletePOByponumber(ponumber);
        pnService.deletePNByPonumber(ponumber);
        mapperService.deleteByPonumber(ponumber);
        try {
            response.sendRedirect("../podetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*return Msg.success();*/
    }


    /**
     * 删除POdetail中PN列表中的PN信息
     * @param pnnumber
     * @return
     */
   /* @RequestMapping("/deletePnByponumber")
    @ResponseBody
    public Msg deletePnByponumber(@PathVariable("pnnumber") Integer pnnumber){
        pnService.deletePnByponumber(pnnumber);
        return Msg.success();
    }*/

}
