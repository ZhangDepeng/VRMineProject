package com.vrmine.vrmineproject.mapper;


import com.vrmine.vrmineproject.entity.Mine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PGL
 * @data 2020/4/16 18:37
 **/
@Repository
@Mapper
public interface MineMapper {
    @Select("select * from mineNameandId")
    public List<Mine> findAll();
}
