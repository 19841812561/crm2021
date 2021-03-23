package com.example.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class IndexController {
@RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/403")
    public String error403(){
        return "403";
    }

}
