package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.entity.Sensor;
import com.vrmine.vrmineproject.serviceImpl.SensorServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/11-19:56
 */
@RestController
public class SensorController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private SensorServiceImpl SensorServiceImpl;

    @GetMapping(value = "/sensor",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询检测模型全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",SensorServiceImpl.findAll());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/sensor/{deviceName}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByname(@PathVariable("deviceName") String deviceName){
        System.out.println("根据deviceName查找检测模型"+localDateTime);
        return ApiResultHandler.success(SensorServiceImpl.findByname(deviceName));
    }

    @GetMapping(value = "/sensor/sensorID/{sensorID}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByid(@PathVariable("sensorID") int sensorID){
        System.out.println("根据sensorID查找检测模型"+localDateTime);
        return ApiResultHandler.success(SensorServiceImpl.findByid(sensorID));
    }

    @PutMapping(value = "/sensor/sensorID",produces = { "application/json;charset=UTF-8" })
    @CrossOrigin
    public ApiResult update(Sensor sensor){
        return ApiResultHandler.success(SensorServiceImpl.update(sensor));
    }
}
