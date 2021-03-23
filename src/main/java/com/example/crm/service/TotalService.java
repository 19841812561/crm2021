package com.example.crm.service;

import com.example.crm.model.*;

import java.util.List;

public interface TotalService {
    public PageResult<Total> findPageResult(Total condition, int page, int pageSize);

    public void save(Total total);


    Total findByIdOrder(String id);

    void deleteByIdOrder(String id);

    void update(Total total);

    List<ShowCount> getShowCount();

    void updateTotal(String name);
    String findMaterialCount();

    String findTotalCount();
}
