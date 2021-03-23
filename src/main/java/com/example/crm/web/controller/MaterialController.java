package com.example.crm.web.controller;

import com.example.crm.model.Admin;
import com.example.crm.model.CURDResult;
import com.example.crm.model.Material;
import com.example.crm.model.PageResult;
import com.example.crm.service.AdminService;
import com.example.crm.service.MaterialService;
import com.example.crm.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @Autowired
    TotalService totalService;

    @RequestMapping("list")
    public String list() {
        return "material/list";
    }


    @RequestMapping("listUnPass")
    public String listUnPass() {
        return "material/listUnPass";
    }

    @RequestMapping("add")
    public String add() {
        return "material/add";
    }

    @RequestMapping("change")
    public String change(Model model, String id) {
        Material material = materialService.findByIdOrder(id);
        model.addAttribute("material", material);
        return "material/change";
    }

    @RequestMapping("detail")
    public String detail(Model model, String id) {
        Material material = materialService.findByIdOrder(id);
        model.addAttribute("material", material);
        return "material/detail";
    }

    @RequestMapping("delete")
    @ResponseBody
    public CURDResult delete(String id,String name) {
        CURDResult result = new CURDResult();
        materialService.deleteByIdOrder(id);
        System.out.println(name);
        totalService.updateTotal(name);

        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public CURDResult save(Material material) {
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

        materialService.save(material);
        totalService.updateTotal(material.getName());

        System.out.println(material.getName());

        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public CURDResult update(Material material) {
        CURDResult result = new CURDResult();
        //{success:1;msg:""}

        materialService.update(material);
        totalService.updateTotal(material.getName());

        System.out.println(material);

        return result;
    }

    @RequestMapping("listJsonPass")
    @ResponseBody
    /**
     * page 显示的当前页
     * limit 每次显示多少条
     */
    public PageResult<Material> listJson(Material condition, int page, int limit) {
        PageResult<Material> result = materialService.findPageResult(condition, page, limit);//limit就是pageSize
        return result;
    }

    @RequestMapping("listJsonUnPass")
    @ResponseBody
    /**
     * page 显示的当前页
     * limit 每次显示多少条
     */
    public PageResult<Material> listJsonUnPass(Material condition, int page, int limit) {
        PageResult<Material> resultUnPass = materialService.findPageResultUnPass(condition, page, limit);//limit就是pageSize
        return resultUnPass;
    }


}
