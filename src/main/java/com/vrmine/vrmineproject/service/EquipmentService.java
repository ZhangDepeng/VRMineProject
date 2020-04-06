package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Equipment;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-18:46
 */
public interface EquipmentService {
    public List<Equipment> findAll();
    public List<Equipment> findByname(String equipmentType);
    public Equipment findByid(int equipmentID);
    int update(int equipmentID);

}
