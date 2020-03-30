package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.entity.Sensor;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-20:09
 */
public interface SensorService {
    public List<Sensor> findAll();
    public List<Sensor> findByname(String deviceName);
    public Sensor findByid(int sensorID);
    public int update(Sensor sensor);
}
