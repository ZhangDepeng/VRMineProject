package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.serviceImpl.CoalseamServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/14-22:14
 */
@RestController
public class CoalseamController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private CoalseamServiceImpl coalseamServiceImpl;

    @GetMapping(value = "/coalseam",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询设备全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",coalseamServiceImpl.findAll());
        System.out.println(apiResult);
        return apiResult;
    }
}
