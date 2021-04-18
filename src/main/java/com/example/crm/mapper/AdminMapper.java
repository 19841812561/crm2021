package com.example.crm.mapper;

import com.example.crm.model.AddressCount;
import com.example.crm.model.Admin;
import com.example.crm.model.State;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    public int findCountByMap(Map<String, Object> map);

    public List<Admin> findListByMap(Map<String, Object> map);

    public void insert(Admin admin);

    public Admin findByOrderId(String id);

    void deleteByOrderId(String id);

    void update(Admin admin);

    List<AddressCount> getAddressCount();


    Admin findByAdminNameAndPassword(String username);

    String findAdminCount();

    void changeStateById(String id, String state);

    void updateState(State state);
}
