package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.entity.Sensor;
import com.vrmine.vrmineproject.mapper.SensorMapper;
import com.vrmine.vrmineproject.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/11-20:10
 */
@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorMapper SensorMapper;

    @Override
    public List<Sensor> findAll() {
        return SensorMapper.findAll();
    }

    @Override
    public List<Sensor> findByname(String deviceName) {
        return SensorMapper.findByname(deviceName);
    }

    @Override
    public Sensor findByid(int sensorID) {
        return SensorMapper.findByid(sensorID);
    }

    @Override
    public int update(Sensor sensor) { return SensorMapper.update(sensor); }
}
