package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Coalseam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:18
 */
@Mapper
public interface CoalseamMapper {

    @Select("select * from coalseam")
    public List<Coalseam> findAll();
}
