package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Equipment;
import com.vrmine.vrmineproject.entity.Sensor;
import com.vrmine.vrmineproject.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-18:47
 */
@Service
public class EquipmentServiceImpl implements EquipmentMapper {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public List<Equipment> findByname(String equipmentType) {
        return equipmentMapper.findByname(equipmentType);
    }

    @Override
    public Equipment findByid(int equipmentID) {
        return equipmentMapper.findByid(equipmentID);
    }

    @Override
    public int update(int equipmentID) { return equipmentMapper.update(equipmentID); }


}
