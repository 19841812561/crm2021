package com.example.crm.service;

import com.example.crm.model.AddressCount;
import com.example.crm.model.CourseOrder;
import com.example.crm.model.PageResult;

import java.util.List;

public interface ICourseOrderService {

    public PageResult<CourseOrder> findPageResult(CourseOrder condition,int page,int pageSize);

    public void save(CourseOrder order);


    CourseOrder findByIdOrder(String id);

    void deleteByIdOrder(String id);

    void update(CourseOrder order);

    List<AddressCount> getAddressCount();

    String findUserCount();
}
