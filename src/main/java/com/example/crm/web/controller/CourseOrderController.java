package com.example.crm.web.controller;

import com.example.crm.model.CURDResult;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;
import com.example.crm.service.ICourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/courseorder")
public class CourseOrderController {
    @Autowired
    ICourseOrderService orderService;

    @RequestMapping("list")
    public String list() {
        return "courseorder/list";
    }

    @RequestMapping("add")
    public String add() {
        return "courseorder/add";
    }

    @RequestMapping("change")
    public String change(Model model, String id) {
        CourseOrder order = orderService.findByIdOrder(id);
        model.addAttribute("order", order);
        return "courseorder/change";
    }

    @RequestMapping("notice")
    public String notice() {
        return "courseorder/notice";
    }

    @RequestMapping("noticelist1")
    public String noticelist1() {
        return "courseorder/noticelist1";
    }

    @RequestMapping("noticelist2")
    public String noticelist2() {
        return "courseorder/noticelist2";
    }

    @RequestMapping("noticelist3")
    public String noticelist3() {
        return "courseorder/noticelist3";
    }

    @RequestMapping("noticenav")
    public String noticenav() {
        return "courseorder/noticenav";
    }

    @RequestMapping("detail")
    public String detail(Model model, String id) {
        CourseOrder order = orderService.findByIdOrder(id);
        model.addAttribute("order", order);
        return "courseorder/detail";
    }

    @RequestMapping("delete")
    @ResponseBody
    public CURDResult delete(String id) {
        CURDResult result = new CURDResult();
        orderService.deleteByIdOrder(id);

        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public CURDResult save(CourseOrder order) {
        CURDResult result = new CURDResult();
        //{success:1;msg:""}
        orderService.save(order);


        System.out.println(order);

        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public CURDResult update(CourseOrder order) {
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

        orderService.update(order);


        System.out.println(order);

        return result;
    }

    @RequestMapping("listJson")
    @ResponseBody
    /**
     * page ??????????????????
     * limit ?????????????????????
     */
    public PageResult<CourseOrder> listJson(CourseOrder condition, int page, int limit) {
        PageResult<CourseOrder> result = orderService.findPageResult(condition, page, limit);//limit??????pageSize
        System.out.println(result);
        return result;
    }
}
