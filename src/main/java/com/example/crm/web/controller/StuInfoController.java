package com.example.crm.web.controller;

import com.example.crm.model.Admin;
import com.example.crm.model.CURDResult;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;
import com.example.crm.service.AdminService;
import com.example.crm.service.ICourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stuinfo")
public class StuInfoController {
    @Autowired
    AdminService adminService;

    @RequestMapping("list")
    public String list(){
        return "stuinfo/list";
    }

    @RequestMapping("add")
    public String add(){
        return "stuinfo/add";
    }

    @RequestMapping("change")
    public String change(Model model, String id){
        Admin admin = adminService.findByIdOrder(id);
        model.addAttribute("admin",admin);
        return "stuinfo/change";
    }

    @RequestMapping("detail")
    public String detail(Model model,String id){
        Admin admin = adminService.findByIdOrder(id);
        model.addAttribute("admin",admin);
        return "stuinfo/detail";
    }

    @RequestMapping("delete")
    @ResponseBody
    public CURDResult delete(String id){
        CURDResult result = new CURDResult();
        adminService.deleteByIdOrder(id);

        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public CURDResult save(Admin admin){
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

            adminService.save(admin);


        System.out.println(admin);

        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public CURDResult update(Admin admin){
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

            adminService.update(admin);


        System.out.println(admin);

        return result;
    }


    @RequestMapping("listJson")
    @ResponseBody
    /**
     * page 显示的当前页
     * limit 每次显示多少条
     */
    public PageResult<Admin> listJson(Admin condition, int page, int limit){
        PageResult<Admin> result = adminService.findPageResult(condition,page,limit);//limit就是pageSize
        return result;
    }

}
