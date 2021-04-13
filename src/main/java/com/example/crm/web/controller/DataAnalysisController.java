package com.example.crm.web.controller;

import com.example.crm.model.AddressCount;
import com.example.crm.model.RiseCount;
import com.example.crm.model.ShowCount;
import com.example.crm.service.ICourseOrderService;
import com.example.crm.service.MaterialService;
import com.example.crm.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dataanalysis")
public class DataAnalysisController {
    @Autowired
    ICourseOrderService orderService;

    @Autowired
    MaterialService materialService;

    @Autowired
    TotalService totalService;

    @RequestMapping("income")
    public String income() {
        return "dataanalysis/income";
    }

    @RequestMapping("map")
    public String map() {
        return "dataanalysis/map";
    }
    

    @RequestMapping("rise")
    public String rise() {
        return "dataanalysis/rise";
    }

    @RequestMapping("show")
    public String show() {
        return "dataanalysis/show";
    }

    @RequestMapping("addressCount")
    @ResponseBody
    public List<AddressCount> addressCounts() {
        List<AddressCount> list = orderService.getAddressCount();
        return list;
    }

    @RequestMapping("riseCount")
    @ResponseBody
    public List<RiseCount> riseCount() {
        List<RiseCount> list = materialService.getRiseCount();
        return list;
    }


    @RequestMapping("showCount")
    @ResponseBody
    public List<ShowCount> showCount() {
        List<ShowCount> list = totalService.getShowCount();

        return list;
    }
}
