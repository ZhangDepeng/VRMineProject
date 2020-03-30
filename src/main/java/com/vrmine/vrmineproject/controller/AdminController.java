package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.Admin;
import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.serviceImpl.AdminServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class AdminController {

    LocalDateTime localDateTime = LocalDateTime.now();

    private AdminServiceImpl adminService;
    @Autowired
    public AdminController(AdminServiceImpl adminService){
        this.adminService = adminService;
    }

    @GetMapping(value="/admins",produces = { "application/json;charset=UTF-8" })
    public ApiResult findAll(){
        System.out.println("查询登录账户"+localDateTime);
        return ApiResultHandler.success(adminService.findAll());
    }

    @GetMapping(value="/admin/{adminId}",produces = { "application/json;charset=UTF-8" })
    public ApiResult findById(@PathVariable("adminId") Integer adminId){
        System.out.println("根据ID查找登录账户"+localDateTime);
        return ApiResultHandler.success(adminService.findById(adminId));
    }

    @DeleteMapping(value="/admin/{adminId}",produces = { "application/json;charset=UTF-8" })
    public ApiResult deleteById(@PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return ApiResultHandler.success();
    }

    @PutMapping(value = "/adminPWD",produces = { "application/json;charset=UTF-8" })
    @CrossOrigin(origins = "http://localhost:8090")
    public ApiResult updatePwd(@RequestBody Admin admin) {
        adminService.updatePwd(admin);
        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
    }

    @PutMapping(value = "/admin",produces = { "application/json;charset=UTF-8" })
    public ApiResult update(@RequestBody Admin admin){
        return ApiResultHandler.success(adminService.update(admin));
    }

    @PostMapping(value = "/admin",produces = { "application/json;charset=UTF-8" })
    public ApiResult add(Admin admin){
        return ApiResultHandler.success(adminService.add(admin));
    }
}
