package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.serviceImpl.FaultServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/14-22:15
 */
@RestController
public class FaultController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private FaultServiceImpl faultServiceImpl;

    @GetMapping(value = "/fault",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询设备全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",faultServiceImpl.findAll());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/fault/{faultName}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByname(@PathVariable("faultName") String faultName){
        System.out.println("根据Name查找设备"+localDateTime);
        return ApiResultHandler.success(faultServiceImpl.findByname(faultName));
    }
}
