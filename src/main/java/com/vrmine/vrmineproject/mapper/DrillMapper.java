package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Drill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:19
 */
@Repository
@Mapper
public interface DrillMapper {


    @Select("select * from drilldata")
    public List<Drill> findAll();

    @Select("select * from drilldata where drillName = #{drillName}")
    public Drill findByname(String drillName);
}
