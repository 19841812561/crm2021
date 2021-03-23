package com.example.crm.web.controller;

import com.example.crm.model.Admin;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.ShowCount;
import com.example.crm.service.AdminService;
import com.example.crm.service.ICourseOrderService;
import com.example.crm.service.MaterialService;
import com.example.crm.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    AdminService adminService;

    @Autowired
    ICourseOrderService courseOrderService;

    @Autowired
    TotalService totalService;

    @RequestMapping("home")
    public String home(){
        return "home/home";
    }

    @RequestMapping("adminCount")
    @ResponseBody
    public String findAdminCount(){
        String adminNumber = adminService.findAdminCount();
        return adminNumber;
    }

    @RequestMapping("userCount")
    @ResponseBody
    public String findUserCount(){
        String userNumber = courseOrderService.findUserCount();
        return userNumber;
    }

    @RequestMapping("materialCount")
    @ResponseBody
    public String findMaterialCount(){
        String materialNumber = totalService.findMaterialCount();
        return materialNumber;
    }

    @RequestMapping("totalCount")
    @ResponseBody
    public String findTotalCount(){
        String userNumber = totalService.findTotalCount();
        return userNumber;
    }
}
