package com.example.crm.service;

import com.example.crm.model.AddressCount;
import com.example.crm.model.Admin;
import com.example.crm.model.PageResult;
import com.example.crm.model.State;

import java.util.List;

public interface AdminService {
    PageResult<Admin> findPageResult(Admin condition, int page, int pageSize);

    void save(Admin admin);


    Admin findByIdOrder(String id);


    void changeStateById(String id, String state);

    void deleteByIdOrder(String id);

    void update(Admin admin);

    List<AddressCount> getAddressCount();

    Admin login(String username);

    String findAdminCount();

    void updateState(State state);
}
