package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Workingsurface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:20
 */
@Repository
@Mapper
public interface WorkingsurfaceMapper {

    @Select("select * from workingsurfacedata")
    public abstract List<Workingsurface> findAll();

    @Select("select * from workingsurfacedata where workingSurfaceName = #{workingSurfaceName}")
    public abstract Workingsurface findByname(String faultName);
}
