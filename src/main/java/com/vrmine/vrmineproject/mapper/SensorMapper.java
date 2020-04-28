package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-20:07
 */
@Repository
@Mapper
public interface SensorMapper {

    @Select("select * from sensordata")
    public List<Sensor> findAll();

    @Select("select * from sensordata where deviceName = #{deviceName}")
    public List<Sensor> findByname(String deviceName);

    @Select("select * from sensordata where sensorID = #{sensorID}")
    public Sensor findByid(int sensorID);

    @Update("update sensordata set posX = #{posX}," +
            "posY = #{posY}, posZ = #{posZ},RotationX = #{RotationX},RotationY = #{RotationY}," +
            "RotationZ = #{RotationZ},ScaleX = #{ScaleX},ScaleY = #{ScaleY},ScaleZ = #{ScaleZ},TransX = #{TransX},TransY = #{TransY},TransZ = #{TransZ} where sensorID = #{sensorID}")
    public int update(Sensor sensor);
}
