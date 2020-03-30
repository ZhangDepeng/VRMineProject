package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Admin;
import com.vrmine.vrmineproject.mapper.LoginMapper;
import com.vrmine.vrmineproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return loginMapper.adminLogin(username,password);
    }
}
