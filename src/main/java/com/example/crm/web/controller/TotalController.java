package com.example.crm.web.controller;

import com.example.crm.model.CURDResult;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;
import com.example.crm.model.Total;
import com.example.crm.service.ICourseOrderService;
import com.example.crm.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/total")
public class TotalController {
    @Autowired
    TotalService totalService;

    @RequestMapping("list")
    public String list(){
        return "total/list";
    }

    @RequestMapping("add")
    public String add(){
        return "total/add";
    }

    @RequestMapping("change")
    public String change(Model model,String id){
        Total total = totalService.findByIdOrder(id);
        model.addAttribute("total",total);
        return "total/change";
    }

    @RequestMapping("detail")
    public String detail(Model model,String id){
        Total total = totalService.findByIdOrder(id);
        model.addAttribute("total",total);
        return "total/detail";
    }

    @RequestMapping("delete")
    @ResponseBody
    public CURDResult delete(String id){
        CURDResult result = new CURDResult();
        totalService.deleteByIdOrder(id);

        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public CURDResult save(Total total){
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

        totalService.save(total);


        System.out.println(total);

        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public CURDResult update(Total total){
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

            totalService.update(total);


        System.out.println(total);

        return result;
    }

    @RequestMapping("listJson")
    @ResponseBody
    /**
     * page 显示的当前页
     * limit 每次显示多少条
     */
    public PageResult<Total> listJson(Total condition, int page, int limit){

        PageResult<Total> result = totalService.findPageResult(condition,page,limit);//limit就是pageSize
        System.out.println(result);
        return result;
    }
}
