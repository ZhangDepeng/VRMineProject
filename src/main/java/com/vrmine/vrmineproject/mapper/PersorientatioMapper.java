package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Persorientatio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/10-20:58
 */
@Mapper
public interface PersorientatioMapper {

    @Select("select * from persorientatio")
    public List<Persorientatio> findAll();

    @Select("select * from persorientatio where Name = #{Name}")
    public Persorientatio findByname(String Name);

    @Select("select * from persorientatio where ID = #{ID}")
    public Persorientatio findByid(int ID);

    @Select("select ID from persorientatio where Installationsite = #{Installationsite}")
    public Persorientatio findByInstallationsite(String Installationsite);

    @Update("update persorientatio set posX = #{posX}," +
            "posY = #{posY}, posZ = #{posZ},RotationX = #{RotationX},RotationY = #{RotationY}," +
            "RotationZ = #{RotationZ},ScaleX = #{ScaleX},ScaleY = #{ScaleY},ScaleZ = #{ScaleZ},TransX = #{TransX},TransY = #{TransY},TransZ = #{TransZ} where ID = #{ID}")
    public int update(Persorientatio persorientatio);
}
