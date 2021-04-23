package com.example.crm.service.impl;

import com.example.crm.mapper.AdminMapper;
import com.example.crm.model.AddressCount;
import com.example.crm.model.Admin;
import com.example.crm.model.PageResult;
import com.example.crm.model.State;
import com.example.crm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public PageResult<Admin> findPageResult(Admin condition, int page, int pageSize) {
        PageResult<Admin> result = new PageResult<Admin>();
        result.setCode(0);
        /**
         * 查询参数先设置为空
         */
        Map<String, Object> params = new HashMap<String, Object>();
        //select * from user limit 0,10
        params.put("condition", condition);//模糊查询
        params.put("start", (page - 1) * pageSize);
        params.put("pageSize", pageSize);


        //获取总记录数据
        int totalCount = adminMapper.findCountByMap(params);

        result.setCount(totalCount);

        //获取查询的数据
        List<Admin> list = adminMapper.findListByMap(params);


        result.setData(list);
        return result;
    }

    @Override
    public void save(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public Admin findByIdOrder(String id) {
        return adminMapper.findByOrderId(id);
    }

    @Override
    public void changeStateById(String id, String state) {
        adminMapper.changeStateById(id, state);
    }

    @Override
    public void deleteByIdOrder(String id) {
        adminMapper.deleteByOrderId(id);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public List<AddressCount> getAddressCount() {
        return adminMapper.getAddressCount();
    }


    @Override
    public String findAdminCount() {
        return adminMapper.findAdminCount();
    }

    @Override
    public void updateState(State state) {
        adminMapper.updateState(state);
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return adminMapper.getAdmin(admin);
    }
}
