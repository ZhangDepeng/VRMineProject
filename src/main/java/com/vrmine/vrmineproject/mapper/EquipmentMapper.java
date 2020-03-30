package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Equipment;
import com.vrmine.vrmineproject.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-18:46
 */
@Mapper
public interface EquipmentMapper {

    @Select("select * from equipmentdata")
    public List<Equipment> findAll();

    @Select("select * from equipmentdata where equipmentType = #{equipmentType}")
    public List<Equipment> findByname(String equipmentType);

    @Select("select * from equipmentdata where equipmentID = #{equipmentID}")
    public Equipment findByid(int equipmentID);

    @Update("update equipmentdata set equipmentName = #{equipmentName},modelName = #{modelName},type = #{type},parameters = #{parameters},manufacturer = #{manufacturer},equipmentDate = #{equipmentDate},equipmentNum = #{equipmentNum}," +
            "position = #{position},posX = #{posX},posY = #{posY}, posZ = #{posZ},RotationX = #{RotationX},RotationY = #{RotationY}," +
            "RotationZ = #{RotationZ},ScaleX = #{ScaleX},ScaleY = #{ScaleY},ScaleZ = #{ScaleZ},TransX = #{TransX},TransY = #{TransY},TransZ = #{TransZ} where ID = #{ID}")
    public int update(Equipment equipment);

}
