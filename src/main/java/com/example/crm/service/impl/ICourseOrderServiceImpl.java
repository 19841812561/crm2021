package com.example.crm.service.impl;

import com.example.crm.mapper.CourseOrderMapper;
import com.example.crm.model.AddressCount;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;
import com.example.crm.service.ICourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICourseOrderServiceImpl implements ICourseOrderService {
    @Autowired
    CourseOrderMapper orderMapper;

    @Override
    public PageResult<CourseOrder> findPageResult(CourseOrder condition, int page, int pageSize) {
        PageResult<CourseOrder> result = new PageResult<CourseOrder>();
        result.setCode(0);
        /**
         * 查询参数先设置为空
         */
        Map<String,Object> params = new HashMap<String,Object>();
        //select * from user limit 0,10
        params.put("condition",condition);//模糊查询
        params.put("start",(page-1)*pageSize);
        params.put("pageSize",pageSize);


        //获取总记录数据
        int totalCount = orderMapper.findCountByMap(params);

        result.setCount(totalCount);

        //获取查询的数据
        List<CourseOrder> list = orderMapper.findListByMap(params);




        result.setData(list);
        return result;
    }

    @Override
    public void save(CourseOrder order) {
        orderMapper.insert(order);
    }

    @Override
    public CourseOrder findByIdOrder(String id) {
        return orderMapper.findByOrderId(id);
    }

    @Override
    public void deleteByIdOrder(String id) {
        orderMapper.deleteByOrderId(id);
    }

    @Override
    public void update(CourseOrder order) {
        orderMapper.update(order);
    }

    @Override
    public List<AddressCount> getAddressCount() {
        return orderMapper.getAddressCount();
    }

    @Override
    public String findUserCount() {
        return orderMapper.findUserCount();
    }
}
