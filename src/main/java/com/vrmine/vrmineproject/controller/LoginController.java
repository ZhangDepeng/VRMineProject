package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.entity.Admin;
import com.vrmine.vrmineproject.entity.ApiResult;
import com.vrmine.vrmineproject.entity.Login;
import com.vrmine.vrmineproject.serviceImpl.LoginServiceImpl;
import com.vrmine.vrmineproject.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @CrossOrigin(origins = "http://localhost:8090")
    @PostMapping(value = "/login",produces = { "application/json;charset=UTF-8" })
    public ApiResult login(@RequestBody @Validated Login login) {

        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin adminRes = loginService.adminLogin(username, password);
        System.out.println(adminRes);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
        }
        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }
}
