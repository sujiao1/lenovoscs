package com.lenovo.lenovoscs.controller;

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
    public String hello(){
        System.out.println("ggggg");
        return po_detail;
    }
}
