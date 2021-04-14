package com.example.crm.mapper;

import com.example.crm.model.Material;
import com.example.crm.model.RiseCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MaterialMapper {
    public int findCountByMap(Map<String, Object> map);

    public List<Material> findListByMap(Map<String, Object> map);

    int findCountByMapUnPass(Map<String, Object> map);

    List<Material> findListByMapUnPass(Map<String, Object> map);

    public void insert(Material material);

    public Material findByOrderId(String id);

    void deleteByOrderId(String id);

    void update(Material material);

    List<RiseCount> getRiseCount();


}
