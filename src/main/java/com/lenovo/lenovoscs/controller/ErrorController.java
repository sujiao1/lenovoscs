package com.lenovo.lenovoscs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class ErrorController {
    /**
     * 404 error
     * @return
     */
    @RequestMapping("/404")
    public String error404() {
        return "views/404";
    }

    /**
     * 500 error
     * @return
     */
    @RequestMapping("/500")
    public String error500() {
        return "views/500";
    }
}
