package com.lenovo.lenovoscs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.lenovoscs.bean.Msg;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.service.PNService;
import com.lenovo.lenovoscs.service.POService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/views")
public class POController {

    @Autowired
   private POService poService;

    @Autowired
    private PNService pnService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/insertPO",method = RequestMethod.POST )
    @ResponseBody
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
    @RequestMapping("/getAllPO")
    @ResponseBody
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
    @RequestMapping("/getAllASN")
    @ResponseBody
    public Msg getAllASN(){
        List<Object> poList = poService.getAllASN();
        return Msg.success().add("poList",poList);
    }

    @RequestMapping("/getAllIV")
    @ResponseBody
    public Msg getAllIV()
    {
        List<PO> poList = poService.getAllIV();
        return Msg.success().add("poList",poList);
    }
    /**
     * 根据POnumber查询PO信息
     * @param ponumber
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/selectPOByponumber/{ponumber}")
    @ResponseBody
    public Msg selectPOByponumber(@PathVariable("ponumber") Integer ponumber){
        PO po = poService.selectPOByponumber(ponumber);
        return Msg.success().add("po",po);
    }

    /**
     * 更新PO信息
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePOByponumber")
    @ResponseBody
    public void updatePOByponumber(@Valid PO po, HttpServletResponse response){
        poService.updatePOByponumber(po);
        try {
            response.sendRedirect("../podetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println();
    }

    /**
     * 更新flag
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePOFlag")
    @ResponseBody
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
    @RequestMapping("/updateASNFlag")
    @ResponseBody
    public void updateASNFlag(@Valid PO po,HttpServletResponse response){
        poService.updateASNFlag(po);
        /*return Msg.success();*/
        try {
            response.sendRedirect("../asndetail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新IV信息
     * @param po
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateIVFlag")
    @ResponseBody
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
    public void deletePOByponumber(@PathVariable("ponumber") Integer ponumber,HttpServletResponse response){
        poService.deletePOByponumber(ponumber);
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
