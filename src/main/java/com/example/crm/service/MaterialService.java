package com.example.crm.service;

import com.example.crm.model.Material;
import com.example.crm.model.PageResult;
import com.example.crm.model.RiseCount;

import java.util.List;

public interface MaterialService {
    PageResult<Material> findPageResult(Material condition, int page, int pageSize, int checkFlg);

    PageResult<Material> findPageResultUnPass(Material condition, int page, int pageSize);

    void save(Material material);

    Material findByIdOrder(String id);

    void deleteByIdOrder(String id);

    void update(Material material);

    List<RiseCount> getRiseCount();

    void pass(int id);
}
