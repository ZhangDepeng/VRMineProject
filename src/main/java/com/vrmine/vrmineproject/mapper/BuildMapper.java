package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Build;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:12
 */
@Mapper
public interface BuildMapper {

    @Select("select * from builddata")
    public List<Build> findAll();

    @Select("select * from builddata where buildingName = #{buildingName}")
    public Build findByname(String buildingName);
}
