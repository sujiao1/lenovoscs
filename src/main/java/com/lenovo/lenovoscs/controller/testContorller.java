package com.lenovo.lenovoscs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/test")
public class testContorller {

    private String po_detail= "index";

    @RequestMapping("/hello")
    @ApiOperation("此处是启动页")
    public String hello(){
        System.out.println("ggggg");
        return po_detail;
    }
}
