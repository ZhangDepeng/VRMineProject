package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.entity.Equipment;
import com.vrmine.vrmineproject.entity.Sensor;
import com.vrmine.vrmineproject.serviceImpl.EquipmentServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/11-18:45
 */
@RestController
public class EquipmentController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private EquipmentServiceImpl equipmentServiceImpl;

    @GetMapping(value = "/equipment",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询设备全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",equipmentServiceImpl.findAll());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/equipment/{equipmentType}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByname(@PathVariable("equipmentType") String equipmentType){
        System.out.println("根据Type查找设备"+localDateTime);
        return ApiResultHandler.success(equipmentServiceImpl.findByname(equipmentType));
    }

    @GetMapping(value = "/equipment/equipmentID/{equipmentID}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByid(@PathVariable("equipmentID") int equipmentID){
        System.out.println("根据equipmentID查找设备"+localDateTime);
        return ApiResultHandler.success(equipmentServiceImpl.findByid(equipmentID));
    }

//    @PutMapping(value = "/equipment/equipmentID",produces = { "application/json;charset=UTF-8" })
//    public ApiResult update(@RequestBody Equipment equipment){
//        return ApiResultHandler.success(equipmentServiceImpl.update(equipment));
//    }

    @PutMapping(value = "/equipment/equipmentID",produces = { "application/json;charset=UTF-8" })
    @CrossOrigin
    public ApiResult update( Equipment equipment) {
        int res = equipmentServiceImpl.update(equipment);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
}
