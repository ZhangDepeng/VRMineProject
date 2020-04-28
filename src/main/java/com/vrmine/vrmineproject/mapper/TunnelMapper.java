package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Tunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/6-21:43
 */
@Repository
@Mapper
public interface TunnelMapper {
    /*修改人：pgl*/
    @Select("select * from ${mineTable}")
    public List<Tunnel> findAll(@Param(value="mineTable") String mineTable);
    /*修改人：pgl*/
    @Select("select * from tunneldata where tunnelName = #{tunnelName}")
    public List<Tunnel> findByName(String tunnelName);
    @Select("select distinct tunnelName from tunneldata")
    public List<Tunnel> findTunnelName();
}
