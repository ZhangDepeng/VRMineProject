package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Fault;
import com.vrmine.vrmineproject.mapper.FaultMapper;
import com.vrmine.vrmineproject.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:25
 */
@Service
public class FaultServiceImpl implements FaultService {
    @Autowired
    private FaultMapper faultMapper;

    @Override
    public List<Fault> findAll() {
        return faultMapper.findAll();
    }

    @Override
    public Fault findByname(String faultName) {
        return faultMapper.findByname(faultName);
    }
}
