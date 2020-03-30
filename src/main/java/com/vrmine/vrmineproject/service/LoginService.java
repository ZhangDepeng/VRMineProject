package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Admin;

public interface LoginService {

    public Admin adminLogin(Integer username, String password);
}
