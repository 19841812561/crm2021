package com.example.crm.service;

import com.example.crm.model.*;

import java.util.List;

public interface MaterialService {
    public PageResult<Material> findPageResult(Material condition, int page, int pageSize);

    public void save(Material material);


    Material findByIdOrder(String id);

    void deleteByIdOrder(String id);

    void update(Material material);

    List<RiseCount> getRiseCount();


}
