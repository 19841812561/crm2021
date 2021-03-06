package com.example.crm.service.impl;

import com.example.crm.mapper.MaterialMapper;
import com.example.crm.model.Material;
import com.example.crm.model.PageResult;
import com.example.crm.model.RiseCount;
import com.example.crm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public PageResult<Material> findPageResult(Material condition, int page, int pageSize, int checkFlg) {
        PageResult<Material> result = new PageResult<Material>();
        result.setCode(0);
        /**
         * 查询参数先设置为空
         */
        Map<String, Object> params = new HashMap<String, Object>();
        //select * from user limit 0,10
        params.put("condition", condition);//模糊查询
        params.put("start", (page - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("flg", checkFlg);

        //获取总记录数据
        int totalCount = materialMapper.findCountByMap(params);

        result.setCount(totalCount);

        //获取查询的数据
        List<Material> list = materialMapper.findListByMap(params);


        result.setData(list);
        return result;
    }

    @Override
    public PageResult<Material> findPageResultUnPass(Material condition, int page, int pageSize) {
        PageResult<Material> result = new PageResult<Material>();
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
        int totalCount = materialMapper.findCountByMapUnPass(params);

        result.setCount(totalCount);

        //获取查询的数据
        List<Material> list = materialMapper.findListByMapUnPass(params);


        result.setData(list);
        return result;
    }

    @Override
    public void save(Material material) {
        materialMapper.insert(material);
    }

    @Override
    public Material findByIdOrder(String id) {
        return materialMapper.findByOrderId(id);
    }

    @Override
    public void deleteByIdOrder(String id) {
        materialMapper.deleteByOrderId(id);
    }

    @Override
    public void update(Material material) {
        materialMapper.update(material);
    }

    @Override
    public List<RiseCount> getRiseCount() {
        return materialMapper.getRiseCount();
    }

    @Override
    public void pass(int id) {
        materialMapper.pass(id);
    }


}
