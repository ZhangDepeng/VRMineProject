package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Build;

import com.vrmine.vrmineproject.mapper.BuildMapper;
import com.vrmine.vrmineproject.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:13
 */
@Service
public class BuildServiceImpl implements BuildService {
    @Autowired
    private BuildMapper buildMapper;

    @Override
    public List<Build> findAll() {
        return buildMapper.findAll();
    }
}
