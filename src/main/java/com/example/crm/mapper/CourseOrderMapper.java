package com.example.crm.mapper;

import com.example.crm.model.AddressCount;
import com.example.crm.model.CourseOrder;

import java.util.List;
import java.util.Map;

public interface CourseOrderMapper {
    public int findCountByMap(Map<String,Object> map);

    public List<CourseOrder> findListByMap(Map<String,Object> map);

    public void insert(CourseOrder order);

    public CourseOrder findByOrderId(String id);

    void deleteByOrderId(String id);

    void update(CourseOrder order);

    List<AddressCount> getAddressCount();

    String findUserCount();
}
