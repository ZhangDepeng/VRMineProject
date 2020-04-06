package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.serviceImpl.PersorientatioServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author zdp
 * @data 2019/12/10-21:08
 */
@RestController
public class PersorientatioController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private PersorientatioServiceImpl persorientatioServiceImplService;

    @GetMapping(value = "/persorientatio",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询人员定位"+localDateTime);
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200,"请求成功",persorientatioServiceImplService.findAll());
        System.out.println(apiResult);
        return apiResult;
    }

    @GetMapping(value = "/persorientatio/{Name}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findByname(@PathVariable("Name") String Name){
        System.out.println("根据Name查找人员"+localDateTime);
        return ApiResultHandler.success(persorientatioServiceImplService.findByname(Name));
    }

    @GetMapping(value = "/persorientatio/ID/{ID}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findBy(@PathVariable("ID") int ID){
        System.out.println("根据ID查找检测模型"+localDateTime);
        return ApiResultHandler.success(persorientatioServiceImplService.findByid(ID));
    }

    @PutMapping(value = "/persorientatio/ID",produces = { "application/json;charset=UTF-8" })
    @CrossOrigin
    public ApiResult update(@RequestBody Persorientatio persorientatio){
        return ApiResultHandler.success(persorientatioServiceImplService.update(persorientatio));
    }
}
