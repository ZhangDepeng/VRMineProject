package com.vrmine.vrmineproject.controller;


import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.serviceImpl.MineServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author PGL
 * @data 2020/4/16 18:53
 **/
@RestController
public class MineController {
    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private MineServiceImpl mineService;

    @ResponseBody
    @GetMapping(value = "/minename",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询全部煤矿名称"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",mineService.findAll());
        System.out.println(apiResult);
        return apiResult;
    }
}
