package com.example.crm.service.impl;

import com.example.crm.mapper.MaterialMapper;
import com.example.crm.mapper.TotalMapper;
import com.example.crm.model.*;
import com.example.crm.service.MaterialService;
import com.example.crm.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TotalServiceImpl implements TotalService {
    @Autowired
   TotalMapper totalMapper;

    @Override
    public PageResult<Total> findPageResult(Total condition, int page, int pageSize) {
        PageResult<Total> result = new PageResult<Total>();
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
        int totalCount = totalMapper.findCountByMap(params);

        result.setCount(totalCount);

        //获取查询的数据
        List<Total> list = totalMapper.findListByMap(params);




        result.setData(list);
        return result;
    }

    @Override
    public void updateTotal(String name) {
        totalMapper.updateTotal();
    }

    @Override
    public void save(Total total) {
        totalMapper.insert(total);
    }

    @Override
    public Total findByIdOrder(String id) {
        return totalMapper.findByOrderId(id);
    }

    @Override
    public void deleteByIdOrder(String id) {
        totalMapper.deleteByOrderId(id);
    }

    @Override
    public void update(Total total) {
        totalMapper.update(total);
    }

    @Override
    public List<ShowCount> getShowCount() {
        return totalMapper.getShowCount();
    }

    @Override
    public String findMaterialCount() {
        return totalMapper.findMaterialCount();
    }

    @Override
    public String findTotalCount() {
        return totalMapper.findTotalCount();
    }

}
