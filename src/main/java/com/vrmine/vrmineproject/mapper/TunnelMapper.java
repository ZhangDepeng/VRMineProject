package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Tunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/6-21:43
 */
@Mapper
public interface TunnelMapper {
    @Select("select * from tunneldata")
    public List<Tunnel> findAll();

    @Select("select * from tunneldata where tunnelName = #{tunnelName}")
    public List<Tunnel> findByName();

    @Select("select distinct tunnelName from tunneldata")
    public List<Tunnel> findTunnelName();
}
