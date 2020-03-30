package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Admin;

import java.util.List;

public interface AdminService{

    public List<Admin> findAll();

    public Admin findById(Integer adminId);

    public int deleteById(int adminId);

    public int updatePwd(Admin admin);

    public int update(Admin admin);

    public int add(Admin admin);
}
