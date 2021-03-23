package com.example.crm.service;

import com.example.crm.model.AddressCount;
import com.example.crm.model.Admin;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;

import java.util.List;

public interface AdminService {
    public PageResult<Admin> findPageResult(Admin condition, int page, int pageSize);

    public void save(Admin admin);


    Admin findByIdOrder(String id);

    void deleteByIdOrder(String id);

    void update(Admin admin);

    List<AddressCount> getAddressCount();

    Admin login(String username);

    String findAdminCount();
}
