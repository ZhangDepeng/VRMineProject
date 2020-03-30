package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Fault;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:19
 */
@Mapper
public interface FaultMapper {

    @Select("select * from faultdata")
    public abstract List<Fault> findAll();

    @Select("select * from faultdata where faultName = #{faultName}")
    public abstract Fault findByname(String faultName);
}
