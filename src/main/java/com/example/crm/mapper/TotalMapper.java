package com.example.crm.mapper;

import com.example.crm.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface TotalMapper {

    int findCountByMap(Map<String,Object> map);

    List<Total> findListByMap(Map<String,Object> map);

    void insert(Total total);

    Total findByOrderId(String id);

    void deleteByOrderId(String id);

    void update(Total total);

    List<ShowCount> getShowCount();

    void updateTotal(String name);

    String findMaterialCount();

    String findTotalCount();
}
