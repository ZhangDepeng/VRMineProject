package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.serviceImpl.TunnelServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/6-22:10
 */
@RestController
public class TunnelController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private TunnelServiceImpl tunnelService;

    @GetMapping(value = "/tunneldata",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询巷道全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",tunnelService.findAll());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/tunneldata/{tunnelName}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByName(){
        System.out.println("查询某一巷道全部"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",tunnelService.findByName());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/tunneldata/tunnelName",produces = { "application/json;charset=UTF-8" })
    public ApiResult findTunnelName(){
        System.out.println("查询巷道名称"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",tunnelService.findTunnelName());
        System.out.println(apiResult);
        return apiResult;
    }
}
